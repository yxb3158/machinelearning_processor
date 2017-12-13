package com.xidian.ml.java.baseKnowledge;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.xidian.ml.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Nullable;
import java.util.List;


/**
 * Created by yxb on 2017/8/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class ListCollectionTest {
    @Test
    public void test1() {
        List<Student> list = Lists.newArrayList();
        List<Integer> ids = Lists.<Integer>newArrayList(Collections2.transform(list, new Function<Student, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable Student input) {
                return input.getId();
            }
        }));

        System.out.println(ids);


    }

    @Test
    public void test2() {
        List<Integer> list = Lists.newArrayList(1,null);
        System.out.println(list);
    }


}
