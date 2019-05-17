package Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    //观察者数组
    private List<Observer> observers = new ArrayList<Observer>();

    private int state;

    public int getState() {
        return state;
    }

    //设置状态：并触发事件更新
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    //添加观察者
    public void attach(Observer observer){
        observers.add(observer);
    }

    //循环通知所有的观察者
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}