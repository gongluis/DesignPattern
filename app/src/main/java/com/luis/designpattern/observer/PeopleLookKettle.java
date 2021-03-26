package com.luis.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/2  14:20
 * desc   :
 */
public class PeopleLookKettle implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println((String)arg);
        System.out.println("People:拔电源倒水~");
    }
}
