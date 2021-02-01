package com.luis.designpattern.decorate;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  19:50
 * desc   :
 */
public class Boy extends Person{
    @Override
    public void dressed() {
        System.out.println("穿衣服");
    }
}
