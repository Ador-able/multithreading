package Singleton;

public class SingletonThree {

    //性能问题严重
    private static SingletonThree instance;

    public SingletonThree() {
    }

    public synchronized static SingletonThree getInstance()
    {
        if(null==instance)
        {
            instance=new SingletonThree();
        }
        return instance;
    }
}
