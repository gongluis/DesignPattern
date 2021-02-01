package com.luis.designpattern.dynamicproxy.staticproxy;

import java.lang.reflect.Proxy;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/1  14:53
 * desc   :
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        RealMovie realMovie = new RealMovie();
        Cinema cinema = new Cinema(realMovie);
        cinema.play();

        DynamicCinema dynamicCinema = new DynamicCinema(realMovie);
        Movie movie = (Movie) Proxy.newProxyInstance(RealMovie.class.getClassLoader(), RealMovie.class.getInterfaces(), dynamicCinema);
        movie.play();

        PuWan puWan = new PuWan();
        DynamicCinema dynamicCinema1 = new DynamicCinema(puWan);
        SellCigarette sellCigarette = (SellCigarette)Proxy.newProxyInstance(PuWan.class.getClassLoader(), PuWan.class.getInterfaces(), dynamicCinema1);
        sellCigarette.sell();
    }
}
