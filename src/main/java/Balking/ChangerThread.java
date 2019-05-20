package Balking;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Random;

public class ChangerThread extends Thread {
    //用户修改数据内容，并执行保存处理
    private final BalkingData data;
    private final Random random = new Random();

    public ChangerThread(String name, BalkingData data) {
        super(name);
        this.data = data;
    }


    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i); //修改数据
                Thread.sleep(random.nextInt(1000)); //执行其他操作
                data.save();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
