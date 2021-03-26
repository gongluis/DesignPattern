package com.luis.designpattern.build;


import android.graphics.Color;
import android.os.HandlerThread;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/2  10:24
 * desc   :
 */
public class BuildTest {
    public static void main(String[] args) {
       //传统的方式 可读性不佳，构造函数太长
        NormalCar p2=new NormalCar("red");
        NormalCar p3=new NormalCar("blue",180000);
        NormalCar p4=new NormalCar("green",21180, "小鹏");
        NormalCar p5=new NormalCar("white",17170,"法拉利","4.0L");

        //build 模式
        BuildCard car = new BuildCard.Builder().color("黑")
                .price(230000)
                .brand("五菱")
                .displacement("1.5")
                .build();
    }


}
