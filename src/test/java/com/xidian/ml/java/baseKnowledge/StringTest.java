package com.xidian.ml.java.baseKnowledge;

import com.google.common.collect.Lists;
import com.xidian.ml.domain.StuExtend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yxb on 2017/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class StringTest {
    @Test
    public void test1() {
        String str1 = "test1 test2";
        String str2 = "test2";
        System.out.println(str1.contains(str2));
    }



    @Test
    public void test2() {
        String appName = null;
        String os = null;
        String sourceKey = appName + "_" + os;
        System.out.println(sourceKey);
        int a=1;
        Integer b=1;
        Integer c=2;
        Integer d=null;
        System.out.println(a==b);
        System.out.println(a==c);
//        System.out.println(a==d);
    }

    @Test
    public void test3() {
        String eventType = "12345890";
        System.out.println(eventType);
        eventType=transOperateType(eventType);
        System.out.println(eventType);
    }

    private String transOperateType(String eventType){
        eventType="qwertyuio";
        return eventType;
    }


    @Test
    public void test4() {
        StuExtend stuExtend1=new StuExtend();
        stuExtend1.setAddress("望京科创大厦");
        stuExtend1.setTelPhoneNum(18519504579l);
       List<StuExtend> list= Lists.newArrayList(stuExtend1,stuExtend1,stuExtend1);
        System.out.println(list.toString().length());
        System.out.println(list.toString());


    }

}
