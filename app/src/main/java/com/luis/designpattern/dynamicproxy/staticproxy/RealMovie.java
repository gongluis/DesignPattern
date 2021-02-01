package com.luis.designpattern.dynamicproxy.staticproxy;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  14:36
 * desc   : 真正的影片
 */
public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("您正在观看《浴血黑帮》");
    }
}
