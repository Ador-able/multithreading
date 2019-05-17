package Singleton;

public class SingletonFour {

    //如果包含外部引用，会引发线程安全问题Five进行改进
    private static SingletonFour instance;

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
