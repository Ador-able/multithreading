package ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerThread extends Thread{
    private final MessageQueue messageQueue;
    private final static Random RANDOM = new Random();

    public ConsumerThread(MessageQueue messageQueue, int seq) {
        super("CONSUMER-" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + " take a message:" + message.getData());
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
