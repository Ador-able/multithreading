package FuturePattern;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService=new FutureService();
        Future<String> submit = futureService.submit(() -> {
            try {
                Thread.sleep(10001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        //});
        },System.out::println);
        System.out.println("===============");
        System.out.println("do other thing");
        Thread.sleep(1000);
        System.out.println("===============");
        //System.out.println(submit.get());
    }
}
