package ProducerAndConsumer;

public class Client {
    public static void main(String[] args) {
        final MessageQueue messageQueue=new MessageQueue();

        new ProducerThread(messageQueue, 1).start();
        new ProducerThread(messageQueue, 2).start();

        new ConsumerThread(messageQueue, 1).start();
        new ConsumerThread(messageQueue, 2).start();
        new ConsumerThread(messageQueue, 3).start();
    }
}
