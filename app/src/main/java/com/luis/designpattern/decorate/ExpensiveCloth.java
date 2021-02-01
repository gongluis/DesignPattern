package com.luis.designpattern.decorate;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  19:56
 * desc   :
 */
public class ExpensiveCloth extends PersonCloth {
    public ExpensiveCloth(Person person) {
        super(person);
    }

    @Override
    public void dressed() {
        //前后均可以添加装饰方法
        super.dressed();
        dressShirt();
        dressjacket();
        dressPants();

    }

    public void dressShirt(){
        System.out.println("穿贵的两根筋");
    }

    public void dressjacket(){
        System.out.println("穿贵的夹克");
    }

    public void dressPants(){
        System.out.println("穿贵的裤子");
    }
}
