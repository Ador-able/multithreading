package Balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BalkingData {
    private final String fileName;
    private String content;
    private boolean changed;

    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        this.content = newContent;
        this.changed = true;
    }

    //这样相当相当不好。在锁里面进行IO操作
    public synchronized void save() {
        if (!changed) {
            return;
        }
        doSave();
        this.changed=false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName()+"calls to save,content="+content);
        try {
            Writer writer=new FileWriter(fileName,true);
            writer.write(content);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
