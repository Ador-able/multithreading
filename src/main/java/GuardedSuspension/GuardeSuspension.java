package GuardedSuspension;

public class GuardeSuspension {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"Alex").start();;
        ServerThread serverThread = new ServerThread(requestQueue);
        serverThread.start();
        Thread.sleep(10000);
        serverThread.close();
    }
}
