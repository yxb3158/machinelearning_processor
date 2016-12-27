package com.xidian.ml.service;

import com.xidian.ml.domain.WmPoiYexiaoStat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yxb on 16/12/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class WmPoiYexiaoServiceTest {

    @Autowired
    private WmPoiYexiaoService wmPoiYexiaoService;

    @Test
    public void UserInfoServiceTest(){
        WmPoiYexiaoStat wmPoiYexiaoStat = wmPoiYexiaoService.getWmPoiTagByPoiId(3);
        System.out.println("result="+wmPoiYexiaoStat);
    }
}
