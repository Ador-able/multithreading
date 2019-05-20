package Balking;

import javax.xml.crypto.Data;

public class Client {
    public static void main(String[] args) {
        BalkingData data = new BalkingData("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
