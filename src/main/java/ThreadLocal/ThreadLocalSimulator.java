package ThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalSimulator<T> {
    private final Map<Thread, T> storage = new HashMap<>();

    public void set(T t) {
        synchronized (this) {
            Thread thread = Thread.currentThread();
            storage.put(thread, t);
        }
    }

    public T get() {
        synchronized (this) {
            Thread thread = Thread.currentThread();
            T value = storage.get(thread);
            if (value == null) {
                return initialValue();
            }
            return value;
        }
    }

    private T initialValue() {
        return null;
    }
}
