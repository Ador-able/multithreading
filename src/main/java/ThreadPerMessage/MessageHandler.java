package ThreadPerMessage;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageHandler {

    private final static Random random = new Random();
    private final static Executor EXECUTOR = Executors.newFixedThreadPool(5);

    ;

    public void request(Message message) {
        EXECUTOR.execute(() -> {
            String value = message.getData();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The Message:" + value + " will be handle by " + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void shutdown() {
        ((ExecutorService) EXECUTOR).shutdown();
    }
}
