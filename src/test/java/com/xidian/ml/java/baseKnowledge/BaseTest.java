package com.xidian.ml.java.baseKnowledge;

import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by yxb on 2017/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class BaseTest {

    @Test
    public void test1() {
        Set<Integer> a = Sets.newHashSet(1, 2, 3);
        Set<Integer> b = Sets.newHashSet(4, 5, 6);
        System.out.println(a + "\t" + b);
        Set<Integer> aa = Sets.newHashSet(a);
        Set<Integer> bb = Sets.newHashSet(b);
        ab(a, b);
        System.out.println(a + "\t" + b);
        System.out.println(aa + "\t" + bb);
    }


    private void ab(Set<Integer> a, Set<Integer> b) {
        Set<Integer> a1 = a;
        Set<Integer> b1 = b;

        a1.clear();
        b1.clear();
    }


    @Test
    public void test2() {
        Integer a = 1;
        Integer b = 2;
        System.out.println(a + "\t" + b);
        ab(a, b);
        System.out.println(a + "\t" + b);
    }


    private void ab(Integer a, Integer b) {
        a = null;
        b = null;
    }

    @Test
    public void test21() throws IOException, ClassNotFoundException {
        Integer a = 12;
        Integer b = 12;
        Integer c = serial(b);
        System.out.println(a == b); //true
        System.out.println(a.equals(b)); //true
        System.out.println(a == c);    //false
        System.out.println(a.equals(c)); //true
        System.out.println();
    }

    @Test
    public void test23() throws IOException, ClassNotFoundException {
        Integer a = 12;
        Integer b = 13;
        Integer c = serial(b);
        System.out.println(a < b);
        System.out.println(a < c);
        System.out.println();
    }


    private Integer serial(Integer b) throws IOException, ClassNotFoundException {
        File file = new File("c.out");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(b); // 保存单例对象
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object sdp = oin.readObject();
        oin.close();
        return (Integer) sdp;
    }


    @Test
    public void test3() {

        int xx = 864000000 + 1345823035;

        BigDecimal x = new BigDecimal(1345823035);
        BigDecimal y = new BigDecimal(864000000);

        BigDecimal xy = x.add(y);


        System.out.println(Integer.MAX_VALUE);
        System.out.println(xx);
        System.out.println(new BigDecimal(xx).longValue());
        System.out.println(xy.longValue() > Integer.MAX_VALUE);
    }


    @Test
    public void test4() {
        Integer a = 1;
        Integer b = 127;
        Integer c = 128;
        Integer d = 129;
        Integer e = 12900;

        float a1 = (float) a;
        float b1 = (float) b;
        float c1 = (float) c;
        float d1 = d;
        float e1 = (float) e;

        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);
        System.out.println(d1);
        System.out.println(e1);


    }

    @Test
    public void test5() {
        int requestTime = 0;
        long a = 1509504270000l;
        long b = 1509514270001l;
        requestTime += (b - a);
        System.out.println(a + "\t" + b);
        int xx = (requestTime + 1) / (100 + 1);
        System.out.println(requestTime);
        System.out.println(xx);

        long a1 = 1l;
        long b1 = 2000l;
        requestTime += (b1 - a1);
        System.out.println(a1 + "\t" + b1);
        int xx1 = (requestTime + 1) / (100 + 1);
        System.out.println(requestTime);
        System.out.println(xx1);
    }

    @Test
    public void test6() {
        Integer a=null;
        Integer b=123;
        Object xx = getObjectData(a, b);
        System.out.println(xx);
        Integer c= (Integer) xx;
        System.out.println(c);
        String d1 = null;//前
        String d2 = null;//后
        Object d3 = getObjectData(d1, d2);
        String  d4= (String) d3;
        System.out.println(d3);
        System.out.println(d4);



    }

    private Object getObjectData(Object PreObj, Object currentObj) {
        return null == PreObj ? currentObj : PreObj;
    }

    @Test
    public void test7() {
        long a=1512387515000l;
        int b= (int) (a/1000);
        System.out.println(b);
        int c = (int) (System.currentTimeMillis() / 1000);

        System.out.println(c);
    }




}
