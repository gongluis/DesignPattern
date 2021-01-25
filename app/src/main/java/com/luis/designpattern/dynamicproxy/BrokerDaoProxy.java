package com.luis.designpattern.dynamicproxy;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/1/25  16:16
 * desc   :
 */
public class BrokerDaoProxy implements StarDao{
    private StarDao starDao;

    public BrokerDaoProxy(StarDao starDao) {
        this.starDao = starDao;
    }

    @Override
    public void doWork() {
        //明星工作前的准备
        //。。。
        //明星工作
        starDao.doWork();
        //宣传工作
        //其它演出之外的工作

    }
}
