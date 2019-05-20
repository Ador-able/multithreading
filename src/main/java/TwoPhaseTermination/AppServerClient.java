package TwoPhaseTermination;

import java.io.IOException;

public class AppServerClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer server=new AppServer(13346);
        server.start();

        Thread.sleep(45_000l);
        server.shutdown();
    }
}
