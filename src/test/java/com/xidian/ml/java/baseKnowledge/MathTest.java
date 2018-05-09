package com.xidian.ml.java.baseKnowledge;

import junit.framework.TestCase;

import java.util.Random;

/**
 * Created by yxb on 2017/8/14.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:machinelearning_processor.xml"})
public class MathTest extends TestCase {


//    @Test
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


//    @Test
    public void test2(){
        long startPoiId=10000;

        Random rand = new Random();
        for(int i=0;i<10;i++){
            Long index = rand.nextInt(100)+startPoiId;
            System.out.println(index);
        }

    }
    public void test3(){
        String str = "EC3C55956CFEB2CB5320FDCD74379AC5C8E609F5048B8AD4E5FCA1FA45256E35";
        System.out.println(Math.abs(str.hashCode()));
        System.out.println(str.hashCode());
        System.out.println(str.hashCode()&0x7FFFFFFF);

    }

    public void test4(){
        double x=0.9*10000;
        int y=9990;
        System.out.println(x);

        System.out.println(x>y);
        System.out.println(x<y);


    }



}
