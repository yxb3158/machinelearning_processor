package com.xidian.ml.service;

import com.alibaba.fastjson.JSON;
import com.xidian.ml.dao.CostCtrlDetailDao;
import com.xidian.ml.domain.CostCtrlDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CostCtrlDetailServiceTest extends AbstractServiceTest {

    @Autowired
    private CostCtrlDetailService costCtrlDetailService;

    @Autowired
    private CostCtrlDetailDao costCtrlDetailDao;


    @Test
    public void test1() {
        CostCtrlDetail costCtrlDetail = new CostCtrlDetail(1L, 0, "201804");
        costCtrlDetail.setCostEstimate(10000D);
        Integer ret = costCtrlDetailService.insertCostCtrlDetail(costCtrlDetail);
        System.out.println(ret);

        CostCtrlDetail temp = costCtrlDetailDao.getByUniqueKey(costCtrlDetail);
        System.out.println(JSON.toJSONString(temp));
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println("类名：" + stackTrace[0].getClassName() + "  ,  java文件名：" + stackTrace[0].getFileName() + ",  当前方法名字：" + stackTrace[0].getMethodName() + ""
                + " , 当前代码是第几行：" + stackTrace[0].getLineNumber() + ", ");
        for (StackTraceElement s : stackTrace) {
            System.out.println("类名：" + s.getClassName() + "  ,  java文件名：" + s.getFileName() + ",  当前方法名字：" + s.getMethodName() + ""
                    + " , 当前代码是第几行：" + s.getLineNumber() + ", ");
        }
//        System.out.println("line1: " + new Throwable().getStackTrace()[0].getLineNumber());
//        System.out.println("line2: " + getLineInfo());
        System.out.println("class: " + new Throwable().getStackTrace()[0].getFileName() + "\tline:" + new Throwable().getStackTrace()[0].getLineNumber());


    }

    public static String getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:machinelearning_processor.xml");
        CostCtrlDetailService clazz = ctx.getBean(CostCtrlDetailService.class);
        CostCtrlDetail costCtrlDetail = new CostCtrlDetail(1L, 0, "201805");
        costCtrlDetail.setCostActual(2D);
        costCtrlDetail.setCostEstimate(100D);
        clazz.insertCostCtrlDetail(costCtrlDetail);

    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:machinelearning_processor.xml");
        CostCtrlDetailService clazz = ctx.getBean(CostCtrlDetailService.class);
        for (int i = 1; i < 10; i++) {
            CostCtrlDetail costCtrlDetail = new CostCtrlDetail(1L, 0, "201805");
            costCtrlDetail.setCostActual(2D);
            clazz.updateCostCtrlDetailByAsyn(costCtrlDetail, costCtrlDetail.getCostActual());
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
