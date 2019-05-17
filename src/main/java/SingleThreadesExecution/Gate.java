package SingleThreadesExecution;

public class Gate {
    private  int counter=0;
    private String name="Nobody";
    private String address="Nowhere";

    public synchronized void pass(String name, String address) {
        this.counter = counter++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if(this.name.charAt(0)!=this.address.charAt(0))
        {
            System.out.println("*********BROKEN**********:"+toString());
        }
    }

    @Override
    public  String toString() {
        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
