package ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread extends Thread {
    private final MessageQueue messageQueue;
    private final static Random RANDOM = new Random();
    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQueue messageQueue, int seq) {
        super("PRODUCER-" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String context = "Message-" + counter.getAndIncrement();
                messageQueue.put(new Message(context));
                System.out.println(Thread.currentThread().getName() + " put message:" + context);
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
