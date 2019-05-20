package Context.SimpleContext;

public class ExecutionTask implements  Runnable{
    private QueryFromDBAction queryFromDBAction=new QueryFromDBAction();
    private QueryFromHttpAction queryFromHttpAction=new QueryFromHttpAction();
    @Override
    public void run() {
        final Context context=new Context();
        queryFromDBAction.execute(context);
        queryFromHttpAction.execute(context);
        System.out.println("The user name is "+context.getName()+" and CardId is "+context.getCardId());
    }
}
