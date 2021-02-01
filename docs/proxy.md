#### 什么是代理？  
不直接访问被代理对象，访问被代理对象的方法  
在不修改被代理对象的基础上，通过扩展代理类，进行一些功能附加和增强。

#### 为什么使用代理?

接收前任代码，很多逻辑难以理解，可以通过代理对类进行增强


#### 代理模式  
![proxy.jpg](https://i.loli.net/2021/02/01/uXDNSwLnlF5im98.jpg)

```
1. RealSubject 是委托类，Proxy 是代理类；
2. Subject 是委托类和代理类的接口；
3. request() 是委托类和代理类的共同方法；
4. RealSubject 中有未公开的方法
``` 

```
* 用户只关心接口功能，而不在乎谁提供了功能。上图中接口是 Subject。
* 接口真正实现者是上图的 RealSubject，但是它不与用户直接接触，而是通过代理。
* 代理就是上图中的 Proxy，由于它实现了 Subject 接口，所以它能够直接与用户接触。
* 用户调用 Proxy 的时候，Proxy 内部调用了 RealSubject。所以，Proxy 是中介者，它可以增强 RealSubject 操作。
```  

#### 静态代理  
不修改原有类，通过代理类来扩展功能
```
电影是电影公司委托电影院进行播放，但是影院可以在播放电影的时候，
赚点钱，卖爆米花可乐，广告。
```
1. 首先得有一个接口，通用的接口是代理模式实现的基础
```
public interface Movie {
    void play();
}
```

2. 然后定义一个真正实现这个接口的类,表示真正的影片。  
```
public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("您正在观看《浴血黑帮》");
    }
}
```  
3. 定义代理类电影院  
```
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
```  
cinema就是realMovie的代理类，它也实现Movie接口语，应有play方法，不过在调用play方法时，利益相关，放了广告。  

4. 测试代码  
```
public class StaticProxyTest {

    public static void main(String[] args) {
        //创建被代理类
        RealMovie realMovie = new RealMovie();
        //创建代理类
        Cinema cinema = new Cinema(realMovie);
        //调用代理类方法
        cinema.play();
        }
    }
```  
为什么叫静态代理？因为cinema这个类是实现定义好的  

#### 动态代理  
动态体现在什么地方？  
上面cinema类是代理，我们需要手动编写代码，让cinimal实现Movie接口，而在动态代理中，我们可以让程序在运行的时候自动在内存中创建一个实现Movie接口的代理，为不需要去定义Cinemal这个类，这就是被称为动态代理的原因。  


1. 定义一个DynamicCinemal代理类  
```
public class DynamicCinema implements InvocationHandler {
    Object movie;

    public DynamicCinema(Object movie) {
        this.movie = movie;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始  影院是： "+ this.getClass().getSimpleName());
        method.invoke(movie, args);
        System.out.println("观看结束");
        return null;
    }
}
``` 
2. 定义一个香烟售卖接口  
```
public interface SellCigarette {
    void sell();
}
```  

3. 定义一个普皖香烟实现类  
```
public class PuWan implements SellCigarette{
    @Override
    public void sell() {
        System.out.println("卖的安徽的普皖");
    }
}
```  




编写测试代码：  
```
public class StaticProxyTest {

    public static void main(String[] args) {

        DynamicCinema dynamicCinema = new DynamicCinema(realMovie);
        Movie movie = (Movie) Proxy.newProxyInstance(RealMovie.class.getClassLoader(), RealMovie.class.getInterfaces(), dynamicCinema);
        movie.play();

        PuWan puWan = new PuWan();
        DynamicCinema dynamicCinema1 = new DynamicCinema(puWan);
        SellCigarette sellCigarette = (SellCigarette)Proxy.newProxyInstance(PuWan.class.getClassLoader(), PuWan.class.getInterfaces(), dynamicCinema1);
        sellCigarette.sell();
    }
}
```  
#### 动态代理源码解析  
1. 涉及到的一个非常重要的类  Proxy,正是通过Proxy的newProxyInstance才会动态创建代理。  
```
public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
```  
loader:类加载器  
interface:代码要用来代理的接口  
h:一个InvacationHandler对象  

2. 另一个比较重要的接口InvocationHandler  ,每一个代理的实例都有一个与之关联的InvocationHnadler实现类，如果代理的方法被调用，代理便会通知和转发给内部的InvocationHandler实现类，由他处理
```

public interface InvocationHandler {
 
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable;
        
}
```

    * proxy代理对象
    * method代理对象调用的方法
    * args调用对象中的参数

> Proxy能够生成不同接口类型的代理，通过传入进去的接口通过反射动态生成了一个接口实例。内部先通过缓存来获取实例，获取不到通过ProxyClassFactory生成，通过指定的classLoader和接口数组用工厂方法生成proxy class ,命名是包名+$Proxy+id序号，里面涉及到了native方法。


#### 总结  
1. 代理分为静态代理和动态代理
2. 静态代理，代理类需要自己编写代码，动态代理，代理类通过Proxy.newInstance()方法生成
3. 静态代理和动态代理都需要实现不同接口，实质是面向接口编程
4. 静态代理和动态代理的区别是需不需要开发者自己定义Proxy类
5. 动态代理通过Proxy 动态生成proxy class,但是他也指定了一个InvacationHandler的实现类
6. 代理本质上是为了增强现有代码的功能



















