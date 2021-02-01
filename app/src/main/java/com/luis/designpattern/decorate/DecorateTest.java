package com.luis.designpattern.decorate;

import android.content.Context;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  19:59
 * desc   :
 */
public class DecorateTest {
    public static void main(String[] args) {

        Boy boy = new Boy();
        CheapCloth cheapCloth = new CheapCloth(boy);
        cheapCloth.dressShort();

        ExpensiveCloth expensiveCloth = new ExpensiveCloth(boy);
        expensiveCloth.dressed();


    }

}
