package Singleton;

public class SingletonSix {

    //推荐使用：相当优雅
    //懒加载，性能好，没有锁，线程安全
    public SingletonSix() {
    }

    private static class InstanceHolder {
        private final static SingletonSix instance = new SingletonSix();
    }

    public static SingletonSix getInstance() {
        return InstanceHolder.instance;
    }
}
