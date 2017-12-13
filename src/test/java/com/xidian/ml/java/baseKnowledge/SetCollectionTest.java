package com.xidian.ml.java.baseKnowledge;

import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by yxb on 2017/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class SetCollectionTest {
    private Set<Integer> collectIds = Sets.newHashSet();

    @Test
    public void test1() {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 5);
        Set<Integer> set2 = Sets.newHashSet(1, 2, 3, 4);
        for (int i = 0; i < 3; i++) {
            System.out.println("before="+collectIds);
            if (collectIds.isEmpty()) {
                collectIds.addAll(set1);
            } else {
                collectIds.retainAll(set2);
            }
            System.out.println("after="+collectIds);
        }

    }

    @Test
    public void test2() {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 5);
        System.out.println(set1.contains(1));
        Set<Integer> set2 = Sets.newHashSet();
        System.out.println(set2.contains(1));

    }
    @Test
    public void test3() {
        Set<Integer> set1 = Sets.newHashSet(4,1, 20, 3, 5);
        Set<Integer> set2 = Sets.newHashSet();
//        set1.addAll(set2);
        set2.remove(4);
        System.out.println(set1);
        System.out.println(set2);
    }
}
