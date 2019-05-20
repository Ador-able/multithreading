package FuturePattern;

import java.util.function.Consumer;

public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> task) {
        AsynFuture<T> asynFuture =new AsynFuture<>();
        new Thread(()->{
            T resule=task.call();
            asynFuture.done(resule);
        }).start();
        return  asynFuture;
    }

    public <T> Future<T> submit(final FutureTask<T> task,final Consumer<T> consumer) {
        AsynFuture<T> asynFuture =new AsynFuture<>();
        new Thread(()->{
            T resule=task.call();
            asynFuture.done(resule);
            consumer.accept(resule);
        }).start();
        return  asynFuture;
    }
}
