package com.xidian.ml.java.baseKnowledge;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class TimeTest  extends TestCase {
    @Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();

//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
        Date start = calendar.getTime();
        System.out.println(start);
        System.out.println(new java.text.SimpleDateFormat("yyyyMM").format(new java.util.Date(calendar.getTimeInMillis())));
        System.out.println(calendar.getTimeInMillis()/1000);
    }


    @Test
    public void test11() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        int day=cal.get(Calendar.DATE);//获取日
        int hour=cal.get(Calendar.HOUR);//小时
        int minute=cal.get(Calendar.MINUTE);//分
        int second=cal.get(Calendar.SECOND);//秒
        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
        System.out.println("现在的时间是：公元"+year+"年"+month+"月"+day+"日      "+hour+"时"+minute+"分"+second+"秒       星期"+WeekOfYear);



    }


}
