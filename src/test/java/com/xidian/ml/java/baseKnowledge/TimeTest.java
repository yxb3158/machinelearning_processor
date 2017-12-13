package com.xidian.ml.java.baseKnowledge;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class TimeTest  extends TestCase {
    @Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date start = calendar.getTime();
        System.out.println(start);
        System.out.println(new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date(calendar.getTimeInMillis())));
        System.out.println(calendar.getTimeInMillis()/1000);
    }



}
