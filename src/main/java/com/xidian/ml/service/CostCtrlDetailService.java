package com.xidian.ml.service;

import com.alibaba.fastjson.JSON;
import com.xidian.ml.dao.CostCtrlDetailDao;
import com.xidian.ml.domain.CostCtrlDetail;
import com.xidian.ml.java.threadPool.IThreadWork;
import com.xidian.ml.java.threadPool.VipThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class CostCtrlDetailService {

    @Autowired
    private CostCtrlDetailDao costCtrlDetailDao;
    @Autowired
    private VipThreadPool vipThreadPool;

    public Integer insertCostCtrlDetail(CostCtrlDetail costCtrlDetail) {
        if (null == costCtrlDetail) {
            return 0;
        }
        Integer result = 0;
        try {
            result = costCtrlDetailDao.insert(costCtrlDetail);
        } catch (DuplicateKeyException e) {
            System.out.println("唯一键冲突");
        }
        return result;
    }

    public Integer updateCostCtrlDetail(CostCtrlDetail costCtrlDetail, Double currentCost) {
        if (null == costCtrlDetail) {
            return 0;
        }
        System.out.println("class: " + new Throwable().getStackTrace()[0].getFileName()+"\tline:"+new Throwable().getStackTrace()[0].getLineNumber());
        Integer result = costCtrlDetailDao.updateCostActualByUniqueKey(costCtrlDetail);
        System.out.println("result=" + result+"costCtrlDetail:"+ JSON.toJSONString(costCtrlDetail));

        if (0 == result) {
            //查看ret等于0的原因,可能是没有成本记录也可可能是真超出预算
            CostCtrlDetail temp = costCtrlDetailDao.getByUniqueKey(costCtrlDetail);
            String detail = "未配置成本预算";
            if (null != temp) {
                detail = "成本预算:" + temp.getCostEstimate() + " 已花费:" + temp.getCostActual() + " 本次预计花费:" + currentCost;

            }
            System.out.println("detail=" + detail);
            throw new RuntimeException("\"detail=\" + detail");
        }
        return result;
    }


    public void updateCostCtrlDetailByAsyn(final CostCtrlDetail costCtrlDetail, final Double currentCost) {
        System.out.println("class: " + new Throwable().getStackTrace()[0].getFileName()+"\tline:"+new Throwable().getStackTrace()[0].getLineNumber());

        vipThreadPool.submit(new IThreadWork() {
            @Override
            public void doWork() {
                System.out.println("class: " + new Throwable().getStackTrace()[0].getFileName()+"\tline:"+new Throwable().getStackTrace()[0].getLineNumber());
//                updateCostCtrlDetail(costCtrlDetail,currentCost);
                costCtrlDetailDao.updateCostActualByUniqueKey(costCtrlDetail);
                System.out.println("class: " + new Throwable().getStackTrace()[0].getFileName()+"\tline:"+new Throwable().getStackTrace()[0].getLineNumber());

            }
        });
    }
}
