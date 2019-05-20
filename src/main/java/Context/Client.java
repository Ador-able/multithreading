package Context;

import java.util.stream.IntStream;

//使用线程池时，要记得清理Context，避免取出上次的数据
public class Client {
    public static void main(String[] args) {
        IntStream.range(1, 5).forEach(i -> {
            new Thread(new ExecutionTask()).start();
        });
    }
}
