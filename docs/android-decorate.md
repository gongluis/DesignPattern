#### 什么是装饰模式？  
动态给一个对象添加一些额外的职责  

#### 为什么使用装饰模式？
需要透明且动态的扩展类的功能时。  

#### 如何实现？(主要通过抽象类和继承来实现)

#### 源码  

1. Context本质上是一个抽象类，相当于装饰模式中的抽象组件，内部定义了大量的抽象方法  
```
public abstract class Context {
    
    public abstract void startActivity(@RequiresPermission Intent intent);
    
    public abstract void sendBroadcast(@RequiresPermission Intent intent);
    
}
```
2. 真正的实现是在ContextImpl中完成的，ContextImpl继承Context抽象类，并实现了Context中的抽象方法。
```

public class ContextImpl extends Context {
                ... ...
  @Override
    public void startActivity(Intent intent) {
        warnIfCallingFromSystemProcess();
        startActivity(intent, null);
    }
 
   @Override
    public void startActivity(Intent intent, Bundle options) {
        warnIfCallingFromSystemProcess();
 
        // Calling start activity from outside an activity without FLAG_ACTIVITY_NEW_TASK is
        // generally not allowed, except if the caller specifies the task id the activity should
        // be launched in.
        if ((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0
                && options != null && ActivityOptions.fromBundle(options).getLaunchTaskId() == -1) {
            throw new AndroidRuntimeException(
                    "Calling startActivity() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag."
                    + " Is this really what you want?");
        }
        mMainThread.getInstrumentation().execStartActivity(
                getOuterContext(), mMainThread.getApplicationThread(), null,
                (Activity) null, intent, -1, options);
    }

```  

3. Acticvity从继承关系上来说，并非直接继承Context,而是继承ContextThemeWrapper,然后ContextThemeWapper又继承ContextWrapper,然后ContextWrapper继承Context,conTextWrapper就是我们要找的装饰者，在ContextWrapper中有一个Context的引用，
```

@Override
public void startActivity(Intent intent) {
    mBase.startActivity(intent);
}
 
@Override
public void startActivity(Intent intent, Bundle options) {
    mBase.startActivity(intent, options);
}

```
contextWrapper中的startActivity()方法也仅仅是具体组件实现类ContextImpl对应的方法而已，实质上ContextWrapper中的所有方法都仅仅是调用了ContextImpl中对应的方法而已，具体的包装扩展方法则由具体的ContextWrapper的具体子类来完成，比如我们的activity，Service,Application等。


