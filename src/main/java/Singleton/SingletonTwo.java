package Singleton;

public class SingletonTwo {

    //会引出线程安全性问题
    private static SingletonTwo instance;

    public SingletonTwo() {
    }

    public  static SingletonTwo getInstance()
    {
        if(null==instance)
        {
            instance=new SingletonTwo();
        }
        return instance;
    }

}
