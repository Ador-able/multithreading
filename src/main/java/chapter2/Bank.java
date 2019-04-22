package chapter2;


public class Bank {
    public static void main(String[] args) {



         chapter2.TicketWindow ticketWindow1 = new  chapter2.TicketWindow("一号柜台");
        ticketWindow1.start();

         chapter2.TicketWindow ticketWindow2 = new  chapter2.TicketWindow("二号柜台");
        ticketWindow2.start();

         chapter2.TicketWindow ticketWindow3 = new  chapter2.TicketWindow("三号柜台");
        ticketWindow3.start();

    }
}
