package WorkerThread;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.Random;

public class TransportThread extends Thread {
    private final Channel channel;

    private static final Random RANDOM=new Random(System.currentTimeMillis());

    public TransportThread(String name,Channel channel) {
        super(name);
        this.channel=channel;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            Request request=new Request();
        }
    }
}
