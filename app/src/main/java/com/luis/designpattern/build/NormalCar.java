package com.luis.designpattern.build;

import android.graphics.Color;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/2  10:21
 * desc   :
 */
public class NormalCar {
    String color;
    double price;
    String brand;
    String displacement;

    public NormalCar(String color, double price, String brand, String displacement) {
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.displacement = displacement;
    }

    public NormalCar(String color) {
        this.color = color;
    }

    public NormalCar(String color, double price) {
        this.color = color;
        this.price = price;
    }

    public NormalCar(String color, double price, String brand) {
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }
}
