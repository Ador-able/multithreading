package Context.SimpleContext;

import Context.Context;

import java.util.stream.IntStream;

//使用ThreadLocal可以避免Context从头传到尾
public class Client {
    public static void main(String[] args) {
        IntStream.range(1, 5).forEach(i -> {
            new Thread(new ExecutionTask()).start();
        });
    }
}
