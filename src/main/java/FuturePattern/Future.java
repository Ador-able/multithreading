package FuturePattern;

public interface Future<T> {
    T get() throws InterruptedException;
}
