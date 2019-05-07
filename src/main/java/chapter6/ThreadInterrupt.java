package chapter6;


public class ThreadInterrupt {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {

        /*Thread t = new Thread() {
            @Override
            public void run() {

//                while(true) {
//                    //连续调用isInterrupted()并不会清除中断状态，而是根据传入的ClearInterrupted值来判断是否重置
//                    //interrupted()静态方法会重置中断状态，其ClearInterrupted为true
//                }

                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(isInterrupted());
                        }
                    }
//                System.out.println("isInterrupted:"+isInterrupted());
                }
            }
        };

        t.start();
        Thread.sleep(100);
        System.out.println(t.isInterrupted());
        t.interrupt();//只是提供一个中断信号并不会真正的中断线程
        System.out.println(t.isInterrupted());
        //System.out.println(t.interrupted());
        //System.out.println(t.interrupted());
        //t.stop();*/

        /*Thread t = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    try {
                        MONITOR.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.interrupted());
                    }
                }
            }
        });*/

        /*Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        t.start();
        Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                main.interrupt();
                System.out.println("interrupt");
            }
        };

        t2.start();
        try {
            t.join();   //此时阻断的不是t线程而是main线程。所以中断t线程并不会触发异常
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //---------------------------*/


    }
}
