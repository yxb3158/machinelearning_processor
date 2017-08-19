package com.xidian.ml.java.baseKnowledge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yxb on 2017/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class MathTest {


    @Test
    public void test1(){
        System.out.println(Math.ceil(0*1.0 / 100));
        System.out.println(Math.ceil(99 *1.0/ 100));
        System.out.println(Math.ceil(1*1.0 / 100));
        System.out.println(Math.ceil(100*1.0 / 100));
        System.out.println(Math.ceil(101*1.0 / 100));
        System.out.println(Math.ceil(150 *1.0/ 100));
        System.out.println(Math.ceil(149*1.0 / 100));
        System.out.println((int)Math.ceil(199*1.0 / 100));
    }
}
