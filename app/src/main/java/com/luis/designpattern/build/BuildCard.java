package com.luis.designpattern.build;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/2/2  10:32
 * desc   :
 */
public class BuildCard {
    String color;
    double price;
    String brand;
    String displacement;

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

    public BuildCard(Builder builder) {
        this.brand = builder.brand;
        this.color = builder.color;
        this.displacement = builder.displacement;
        this.price = builder.price;
    }

    public static class Builder {
        String color;
        double price;
        String brand;
        String displacement;

        public Builder color(String color){
            this.color = color;
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }
        public Builder brand(String color){
            this.brand = brand;
            return this;
        }

        public Builder displacement(String displacement){
            this.displacement = displacement;
            return this;
        }


    public BuildCard build(){

        return new BuildCard(this);
    }

    }
}
