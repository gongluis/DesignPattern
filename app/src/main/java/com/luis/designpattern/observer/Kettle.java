package com.luis.designpattern.observer;

import java.util.Observable;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/2  14:18
 * desc   :
 */
public class Kettle extends Observable {
    public void notifyPeople(String str){
        System.out.println("我是水壶");
        setChanged();
        notifyObservers(str);
    }
}
