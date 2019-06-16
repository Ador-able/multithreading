package Singleton;

public class SingletonFour {

    //由于java实例化一个对象的操作（new）不是原子性的。
    // 所以在线程a 在执行到instance = new SingletonFour();时，当其完成了一部分时，instance就已经非null了，
    // 但是此时实例对象并没有构造完成。
    // 假如这个时候线程b进来if语句就会得道instance不是null，
    // 会直接拿到未完成的 instance，从而导致空指针。
    private volatile static SingletonFour instance;

    public SingletonFour() {
    }

    public static SingletonFour getInstance() {
        if (null == instance) {
            synchronized (SingletonFour.class) {
                if (null == instance) {
                    instance = new SingletonFour();
                }
            }
        }
        return instance;
    }
}
