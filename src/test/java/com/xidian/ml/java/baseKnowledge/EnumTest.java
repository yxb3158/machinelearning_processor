package com.xidian.ml.java.baseKnowledge;

import com.xidian.ml.admin.FilterEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yxb on 2017/11/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class EnumTest {

    @Test
    public void test1() {
        String name = FilterEnum.getFilterNameById(4);
        System.out.println(name);

    }
}
