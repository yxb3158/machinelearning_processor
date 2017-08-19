package com.xidian.ml.java.baseKnowledge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yxb on 2017/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class SqlGenerationTest {

    @Test
    public void test1() {
        System.out.println();
        for (int i = 0; i < 100; i++) {
            String sql = "alter table waimai_yunying_cc.activity_collector_poi_data_" + i + " add column wm_sku_ids VARCHAR(255) DEFAULT null  COMMENT '菜品id,逗号分隔' AFTER `score`;";
            System.out.println(sql);
        }


    }


}
