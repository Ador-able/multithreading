package Observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();//派发者

        new HexaObserver(subject);//观察者订阅更新事件
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}