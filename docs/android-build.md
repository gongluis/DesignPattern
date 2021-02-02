### 定义  
1. 原bean新增构造函数，入参为静态内部类Builder，内容是this.properity = builder.properity
2. Builder类中新增build方法，return new Card(this);
3. builder类中定义各个属性赋值方法
```
public Builder color(Color color){
    this.color = color;
    return this;
}
...
```

###   例子  
```
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
```  
### 对比  

```
public class BuildTest {
    public static void main(String[] args) {
       //传统的方式 可读性不佳，构造函数太长
        NormalCar p2=new NormalCar("red");
        NormalCar p3=new NormalCar("blue",180000);
        NormalCar p4=new NormalCar("green",21180, "小鹏");
        NormalCar p5=new NormalCar("white",17170,"法拉利","4.0L");

        //build 模式
        BuildCard car = new BuildCard.Builder().color("黑")
                .price(230000)
                .brand("五菱")
                .displacement("1.5")
                .build();

    }
}
```
builder模式更加直观，构造参数也没那么多。

### 优缺点
链式调用抑郁阅读和编写，出错难以debug