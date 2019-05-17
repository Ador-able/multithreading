package Singleton;

public class SingletonSeven {

    //也推荐使用
    public SingletonSeven() {
    }

    //枚举类型是线程安全的，其构造函数只会被加载一次
    private enum  Singleton
    {
        INSTANCE;

        private final SingletonSeven instance;

        Singleton()
        {
            System.out.println("创建单例");
            instance=new SingletonSeven();
        }

        public  SingletonSeven getInstance()
        {
            return instance;
        }
    }

    public  static  SingletonSeven getInstance()
    {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        SingletonSeven s=new SingletonSeven();
        System.out.println("==============");
        s.getInstance();
    }
}
