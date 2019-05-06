package  chapter3;


public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        }, "Test", 1 << 24);
        //stackSize为0表示忽略该参数，该参数对某些平台无效，表示栈的大小
        t1.start();
    }
}
