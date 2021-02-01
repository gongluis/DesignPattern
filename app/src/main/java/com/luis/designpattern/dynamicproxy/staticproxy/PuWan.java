package com.luis.designpattern.dynamicproxy.staticproxy;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  19:01
 * desc   : 普皖
 */
public class PuWan implements SellCigarette{
    @Override
    public void sell() {
        System.out.println("卖的安徽的普皖");
    }
}
