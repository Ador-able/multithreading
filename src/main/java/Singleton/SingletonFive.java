package Singleton;

public class SingletonFive {
    
    private static volatile SingletonFive instance;

    public SingletonFive() {
    }

    public static SingletonFive getInstance() {
        if (null == instance) {
            synchronized (SingletonFive.class) {
                if (null == instance) {
                    instance = new SingletonFive();
                }
            }
        }
        return instance;
    }
}
