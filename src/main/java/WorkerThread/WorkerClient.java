package WorkerThread;

public class WorkerClient {
    public static void main(String[] args) {
        final Channel channel=new Channel(5);
        channel.startWorker();

        new TransportThread("LXY",channel).start();
        new TransportThread("TOM",channel).start();
        new TransportThread("AYM",channel).start();
    }
}
