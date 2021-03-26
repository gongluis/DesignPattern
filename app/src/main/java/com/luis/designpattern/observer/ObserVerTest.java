package com.luis.designpattern.observer;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/2  14:22
 * desc   :
 */
public class ObserVerTest {


    public static void main(String[] args) {
        //被观察者
        Kettle kettle = new Kettle();
        //观察者
        PeopleLookKettle peopleLookKettle = new PeopleLookKettle();
        kettle.addObserver(peopleLookKettle);
        kettle.notifyPeople("kettle:我是水壶，水开了，再不拔电源我要爆炸了");
    }


}
