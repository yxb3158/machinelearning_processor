package com.xidian.ml.java.baseKnowledge;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by yxb on 2017/12/7.
 */
public class logicTest extends TestCase {
    @Test
    public void test1(){
        long a=244126140;
        long b = a & 255;
        System.out.println("dfghj");
        System.out.println(a);
        System.out.println(Long.toBinaryString(a));
        System.out.println(b);
        System.out.println(Long.toBinaryString(b));
    }

}
