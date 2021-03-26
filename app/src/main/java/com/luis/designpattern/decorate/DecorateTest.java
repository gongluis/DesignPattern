package com.luis.designpattern.decorate;

import android.content.Context;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  19:59
 * desc   :
 */
public class DecorateTest {
    public static void main(String[] args) {

//        Boy boy = new Boy();
//        CheapCloth cheapCloth = new CheapCloth(boy);
//        cheapCloth.dressShort();
//
//        ExpensiveCloth expensiveCloth = new ExpensiveCloth(boy);
//        expensiveCloth.dressed();

        long timeMillis = Calendar.getInstance().getTimeInMillis();
        String day = new SimpleDateFormat("yyyyMMdd").format(timeMillis);

        String start = new StringBuffer(day).append("000000").toString();
        String end = new StringBuffer(day).append("235900").toString();

        System.out.println("start："+start);
        System.out.println("end："+end);
    }

}
