package com.luis.designpattern.decorate;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  19:54
 * desc   :
 */
public class CheapCloth extends PersonCloth{
    public CheapCloth(Person person) {
        super(person);
    }

    @Override
    public void dressed() {
        super.dressed();
        dressShort();
    }

    public void dressShort(){
        System.out.println("穿便宜的两根筋");
    }
}
