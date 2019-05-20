package Context.SimpleContext;

public class QueryFromDBAction {
    public   void  execute(Context context)
    {
        try {
            Thread.sleep(1000L);
            String name="LXY"+Thread.currentThread().getName();
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
