package JDKCountDown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

//分阶段处理任务
public class JDKCountDown {
    private static final Random RANDOM=new Random();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("准备多线程处理任务");

        final CountDownLatch latch=new CountDownLatch(5);
        IntStream.rangeClosed(1,5).forEach(i->{
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" is working");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            },String.valueOf(i)).start();
        });
        latch.await();
        System.out.println("多线程任务全部处理完毕，准备第二阶段任务");

        System.out.println("FINISH");
    }
}
