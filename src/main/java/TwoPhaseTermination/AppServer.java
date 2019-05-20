package TwoPhaseTermination;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppServer extends Thread {
    private int port;
    private static final int DEFAULT_PORT = 19962;
    private volatile boolean start = true;
    private ServerSocket serverSocket;
    private List<ClientHandler> clientHandlers = new ArrayList<>();
    private final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    public AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动");
            while (start) {
                Socket client = serverSocket.accept();
                System.out.println("客户端链接");
                ClientHandler clientHandler = new ClientHandler(client);
                this.clientHandlers.add(clientHandler);
                EXECUTOR_SERVICE.submit(clientHandler);
            }
        } catch (IOException e) {
            ///throw new RuntimeException(e);
        } finally {
            this.dispose();
        }
    }

    private void dispose() {
        this.clientHandlers.stream().forEach(c -> c.stop());
        this.EXECUTOR_SERVICE.shutdown();
    }


    public void shutdown() throws IOException {
        this.start = false;
        this.serverSocket.close();
        this.interrupt();
    }
}
