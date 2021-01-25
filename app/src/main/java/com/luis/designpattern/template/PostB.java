package com.luis.designpattern.template;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/25  17:06
 * desc   :
 */
public class PostB extends Postman{
    @Override
    protected void call() {//联系收货，实现父类的抽象方法

    }

    @Override
    protected boolean isSign() {//是否签收,覆盖父类的钩子方法，控制流程的走向
        return false;
    }

    @Override
    protected void refuse() {//拒签，覆盖父类的钩子方法
        super.refuse();
    }

}
