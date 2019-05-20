package Context;


public class ExecutionTask implements  Runnable{
    private QueryFromDBAction queryFromDBAction=new QueryFromDBAction();
    private QueryFromHttpAction queryFromHttpAction=new QueryFromHttpAction();
    @Override
    public void run() {
        Context context = ActionContext.getActionContext().getContext();
        queryFromDBAction.execute();
        queryFromHttpAction.execute();
        System.out.println("The user name is "+context.getName()+" and CardId is "+context.getCardId());
    }
}
