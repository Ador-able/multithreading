package  chapter4;


public class DaemonThread2 {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println();
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(1_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //innerThread.setDaemon(true);
            innerThread.start();
            System.out.println("判断innerThread是否为守护线程："+innerThread.isDaemon());
            try {
                Thread.sleep(1_000);
                System.out.println("T thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
        //守护线程创建的线程也是守护线程

        Thread.sleep(1000);
    }
}
