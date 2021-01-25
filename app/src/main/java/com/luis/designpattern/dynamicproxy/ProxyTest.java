package com.luis.designpattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/25  16:19
 * desc   : 代理模式的场景，商家找明星做活动要先找经纪人，经纪人负责琐碎或者运营方面工作，明星只需要做具体的活动事宜就行了，经纪人就是一个代理的角色
 */
public class ProxyTest {
    public static void main(String[] args) {
        SuperStarDao superStarDao = new SuperStarDao();
        BrokerDaoProxy brokerDaoProxy = new BrokerDaoProxy(superStarDao);
        brokerDaoProxy.doWork();



//动态代理是不需要提前创建代理对象，例用反射机制在运行时创建代理类，明星不需要具体的经纪人，有活动的时候可以创建经纪人来完成代理工作
        StarDao proxy = (StarDao) Proxy.newProxyInstance(
                superStarDao.getClass().getClassLoader(),
                superStarDao.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*--接活--*/
                        Object returnValue = method.invoke(superStarDao, args);//明星工作
                        /*--宣传工作--*/
                        return returnValue;
                    }
                });

        proxy.doWork();
    }

}
