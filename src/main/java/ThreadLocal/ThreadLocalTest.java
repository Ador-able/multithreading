package ThreadLocal;

import java.util.Random;

public class ThreadLocalTest {
    //private final static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    private final static ThreadLocalSimulator<String> threadLocal= new ThreadLocalSimulator<String>();

    private final static Random RANDOM=new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            threadLocal.set("Thread-T0");
            try {
                Thread.sleep(RANDOM.nextInt(1000));
                System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() ->{
            threadLocal.set("Thread-T1");
            try {
                Thread.sleep(RANDOM.nextInt(1000));
                System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();t2.start();t1.join();t2.join();
        System.out.println("==========================");
        System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
    }
}
