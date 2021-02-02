### 定义
```
基于事件和响应的设计模式  
简单来说多个观察者同时观察一个对象，当对象发生变化的时候观察者能够回调自身的方法更新自己。
```
![observer.png](https://i.loli.net/2020/07/14/17oMWz6nHwOxK2j.png)  

````
1. 定义一个观察者接口
2. 观察者实现观察者接口
3. 定义被观察者接口或者抽象类，里面有addObserver(Observer observer),removeObserver(Observer observer),notifyObserver(),调用notifyObserver(),遍历list<Observer>, 回调onserver里面的方法。
````

### 经典的例子  
游戏中英雄，在地图中中走，捡宝盒增加技能或者踩到陷阱减生命力的。
在这个例子中，宝石，宝剑和陷阱属于观察者ConcreteObserver,英雄属于被观察者，  
如何建立关系呢？  
首先有很多的英雄和很多的道具，抽取共同的行为

```
Public interface Observer{
    void update();
}
```  
宝石
```
public Stone implement Observer{
    public void update(){
        if(inrange()){
            System.out.print("获取到宝石");
        }
        
    }
    public Boolean inrange(){
        //判断是否在距离内
        return true;
    }
    
}
```
陷阱  
```
public Trap implement Observer{
    public void update(){
        if(){
            System.out.print("踩到陷阱");
        }
    }
}
```  

定义抽象类  
```
public abstract Subject{
private List<Observer> observerList = new ArrayList<Observer>();

    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    
    public void deleteObserver(Observer observer){
        observerList.remove(observer);
    }
    
    public void notifyObserver(){
        for(Observer observer: observerList){
            observer.update();
        }
    }
    
}
```    
定义英雄  
```
public class Hero extend Subject{
    
    public void run(){
        notifyObserver();
    }
    
}
```
  
  具体调用  
  ```
  public class client{
      public static void main(String[] args){
      //初始化对象  
      Hero hero = new Hero();
      Stone stone = new Stone();
      Trap trap = new Trap();
      hero.addObserver(stone);
      hero.addObserver(trap);
        hero.run();  
      }
  }  
  代码输出如下：  
  获取到宝石  
  踩到陷阱
 
  ```  
### 优缺点  
1. 解耦观察者被观察者
2. 

### java中的观察者  

> 实现思路同上，被观察者中维护了addObserver()方法，deleteObserver方法，notifyObserver方法。通过队列维护多个observer。多线程访问问题，分别对应新添加的obser和最近解除的observer,通过setChange变量来控制。只有setchange为true才会通知observer


1. 定义被观察者继承observable
```
public class Kettle extends Observable {
    public void notifyPeople(String str){
        System.out.println("我是水壶");
        setChanged();
        notifyObservers(str);
    }
}
```
2. 定义观察者实现Obsever  
```
public class PeopleLookKettle implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println((String)arg);
        System.out.println("People:拔电源倒水~");
    }
}
```  

3. 编写测试代码  
```
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
```  

4. 测试结果输出  
```
我是水壶
kettle:我是水壶，水开了，再不拔电源我要爆炸了
People:拔电源倒水~
```