package com.luis.designpattern.template;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/25  17:08
 * desc   : 模板设计模式
 */
public class TemplateTest {

    public void test(){
        System.out.println("----派送A----");
        Postman postA=new PostA();
        postA.post();
        System.out.println("----派送B----");
        Postman postB=new PostB();
        postB.post();
    }
}
