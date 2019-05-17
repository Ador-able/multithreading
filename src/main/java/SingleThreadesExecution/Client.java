package SingleThreadesExecution;

public class Client {
    public static void main(String[] args) {
        Gate gate=new Gate();
        User bj=new User("BB","BeiJing",gate);
        User sh=new User("SS","ShangHai",gate);
        User sz=new User("LL","LangFang",gate);
        bj.start();sh.start();sz.start();
    }
}
