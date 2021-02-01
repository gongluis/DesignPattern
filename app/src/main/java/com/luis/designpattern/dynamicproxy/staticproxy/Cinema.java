package com.luis.designpattern.dynamicproxy.staticproxy;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  14:40
 * desc   : Proxy类，调用play是影片就开始播放,可以在不修改被代理对象的基础上，通过扩展代理类，进行功能的附加和增强，应当实现同一个接口或者继承同一个类。
 */
public class Cinema implements Movie{

    private final RealMovie moview;

    public Cinema(RealMovie realMovie) {
        this.moview = realMovie;
    }

    @Override
    public void play() {
        guangGao(true);
        moview.play();
        guangGao(false);
    }

    public void guangGao(boolean isStart){
        if (isStart) {
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        }else{
            System.out.println("电影马上结束了，爆米花、可乐、口香糖8.8折，买回家吃吧！");
        }
    }
}
