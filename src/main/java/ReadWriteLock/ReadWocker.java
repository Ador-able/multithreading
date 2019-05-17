package ReadWriteLock;

import java.util.Random;

public class ReadWocker extends Thread {

    private final SharedData data;

    public ReadWocker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBUf = data.read();
                System.out.println(Thread.currentThread().getName()+" reads "+String.valueOf(readBUf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
