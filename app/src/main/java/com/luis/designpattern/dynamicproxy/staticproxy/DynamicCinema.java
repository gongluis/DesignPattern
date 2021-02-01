package com.luis.designpattern.dynamicproxy.staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  16:11
 * desc   :
 */
public class DynamicCinema implements InvocationHandler {
    Object movie;

    public DynamicCinema(Object movie) {
        this.movie = movie;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始  营业的是： "+ this.getClass().getSimpleName());
        method.invoke(movie, args);
        System.out.println("营业结束");
        return null;
    }
}
