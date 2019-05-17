package ReadWriteLock;

public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedData sharedData=new SharedData(10);
        new ReadWocker(sharedData).start();
        new ReadWocker(sharedData).start();
        new ReadWocker(sharedData).start();
        new ReadWocker(sharedData).start();
        new ReadWocker(sharedData).start();
        new WriteWorker(sharedData,"qqqqqqqqqqq").start();
        new WriteWorker(sharedData,"ssssssssssss").start();
        new WriteWorker(sharedData,"vvvvvvvvvvvv").start();
        new WriteWorker(sharedData,"ggggggggggggg").start();
    }
}
