package WaitSet;

import chapter10.Lock;

import java.util.Optional;
import java.util.stream.IntStream;

public class WaitSet {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i ->
                new Thread(String.valueOf(i)) {
                    public void run() {
                        synchronized (LOCK) {
                            try {
                                Optional.of(Thread.currentThread().getName() + "will come to wait").ifPresent(System.out::println);
                                LOCK.wait();
                                Optional.of(Thread.currentThread().getName() + "will leave to wait").ifPresent(System.out::println);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );
        //唤醒的顺序不确定
        IntStream.rangeClosed(1, 10).forEach(i ->
                {
                    synchronized (LOCK)
                    {
                        LOCK.notify();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

    }
}
