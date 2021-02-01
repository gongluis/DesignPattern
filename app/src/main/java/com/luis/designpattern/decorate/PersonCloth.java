package com.luis.designpattern.decorate;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  19:51
 * desc   :
 */
public abstract class PersonCloth extends Person {

    protected Person person;

    public PersonCloth(Person person) {
        this.person = person;
    }

    @Override
    public void dressed() {
        //调用Person类中的dressed方法
        person.dressed();
    }
}
