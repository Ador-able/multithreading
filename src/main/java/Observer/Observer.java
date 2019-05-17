package Observer;

//观察者：即被被通知的对象
public abstract class Observer {
    //要订阅的事件
    protected Subject subject;
    //事件发生后执行的内容
    public abstract void update();
}