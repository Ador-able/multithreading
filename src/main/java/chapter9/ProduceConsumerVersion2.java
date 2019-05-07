package  chapter9;

import java.util.stream.Stream;


public class ProduceConsumerVersion2 {

    private int i = 0;

    final private Object LOCK = new Object();

    private volatile boolean isProduced = false;

    //wait会释放持有的锁，sleep不会释放
    public void produce() {
        synchronized (LOCK) {
            if (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println("P->" + i);
                LOCK.notify();
                isProduced = true;
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                System.out.println("C->" + i);
                LOCK.notify();
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();

        new Thread("P") {
            @Override
            public void run() {
                while (true)
                    pc.produce();
            }
        }.start();

        new Thread("C") {
            @Override
            public void run() {
                while (true)
                    pc.consume();
            }
        }.start();

        //多生产者和多消费者会产生问题
        //并不能确定唤醒得是哪个线程，最终有可能全部处于等待状态
//        Stream.of("P1", "P2").forEach(n ->
//                new Thread(n) {
//                    @Override
//                    public void run() {
//                        while (true)
//                            pc.produce();
//                    }
//                }.start()
//        );
//        Stream.of("C1", "C2").forEach(n ->
//                new Thread(n) {
//                    @Override
//                    public void run() {
//                        while (true)
//                            pc.consume();
//                    }
//                }.start()
//        );
    }
}