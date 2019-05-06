package  chapter4;

import java.util.Optional;


public class ThreadSimpleAPI {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "TreadTest");

        t.start();
        Optional.of("Name:"+t.getName()).ifPresent(System.out::println);
        Optional.of("Id:"+t.getId()).ifPresent(System.out::println);
        Optional.of("Priority:"+t.getPriority()).ifPresent(System.out::println);
        //t.stop();
    }
}
