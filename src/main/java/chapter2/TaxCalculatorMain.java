package  chapter2;


public class TaxCalculatorMain {

    public static void main(String[] args) {
        /*TaxCalaculator calculator = new TaxCalaculator(10000d, 2000d) {

            @Override
            public double calcTax() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };
        double tax = calculator.calculate();
        System.out.println(tax);*/

        TaxCalaculator calculator1 = new TaxCalaculator(10000d, 2000d, (s, b) -> s * 0.1 + b * 0.15);
        TaxCalaculator calculator2 = new TaxCalaculator(10000d, 2000d, new SimpleCalculatorStrategy());
        System.out.println(calculator1.calculate());
        System.out.println(calculator2.calculate());
    }
}
