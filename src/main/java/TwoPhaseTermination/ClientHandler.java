package TwoPhaseTermination;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter pr = new PrintWriter(outputStream)
        ) {
            while (running) {
                String message = br.readLine();
                if(message==null) break;
                System.out.println("Come from client >" + message);
                pr.write("echo: " + message);
                pr.flush();
            }
        } catch (IOException e) {
            this.running = false;
        }finally {
            this.stop();
        }
    }

    public void stop() {
        System.out.println("客户端关闭");
        if (!running) {
            return;
        }
        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
