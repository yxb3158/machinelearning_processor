package com.xidian.ml.java.time;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yxb on 2017/8/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class TimeTest {

    @Test
    public void test1() {
        int time1 = 1491829765;
        long time = 1491829765000l;
        long time2 = (long) time1 * 1000;
        System.out.println(time + "000");
        System.out.println(time);
        System.out.println(time2);
        System.out.println(Long.valueOf(time1 * 1000));

    }

}
