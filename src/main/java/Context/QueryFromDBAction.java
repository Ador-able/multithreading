package Context;

public class QueryFromDBAction {
    public   void  execute()
    {
        try {
            Thread.sleep(1000L);
            String name="LXY"+Thread.currentThread().getName();
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
