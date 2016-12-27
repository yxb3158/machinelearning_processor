package com.xidian.ml.service;

import com.xidian.ml.dao.WmPoiTagDao;
import com.xidian.ml.domain.WmPoiYexiaoStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yxb on 16/12/23.
 */
@Service
public class WmPoiYexiaoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private WmPoiTagDao wmPoiTagDao;


    public WmPoiYexiaoStat getWmPoiTagByPoiId(long wm_poi_id){
        logger.info("getWmPoiTagByPoiId(wm_poi_id:{})",wm_poi_id);
        return wmPoiTagDao.getByWmPoiId(wm_poi_id);
    }

    public String test(long wm_poi_id){
        logger.info("getWmPoiTagByPoiId(wm_poi_id:{})",wm_poi_id);
        return String.valueOf(wm_poi_id);
    }
}
