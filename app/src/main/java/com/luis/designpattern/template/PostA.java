package com.luis.designpattern.template;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/25  17:05
 * desc   :
 */
public class PostA extends Postman{
    @Override
    protected void call() {//联系收货，实现父类的抽象方法
        System.out.println("联系A先生并送到门口");
    }

}
