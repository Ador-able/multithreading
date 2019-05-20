package Balking;

import javax.xml.crypto.Data;
import java.io.IOException;


public class SaverThread extends Thread {
    //用户定期保存数据内容
    private final BalkingData data;

    public SaverThread(String name, BalkingData data) {
        super(name);
        this.data = data;
    }

    /**
     * 在run方法中，每隔1s就调用一次Data实例的save方法，如果文件操作发生错误，则会抛出异常，线程终止。
     */
    public void run() {
        try {
            while (true) {
                data.save();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
