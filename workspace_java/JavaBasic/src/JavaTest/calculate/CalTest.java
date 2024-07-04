package JavaTest.calculate;

public class CalTest {
    public static void main(String[] args) {

        Calculate calculate = new Calculate();

        calculate.setNumber(5,4);

        System.out.println(calculate.getSum());

        System.out.println(calculate.getMax());

        System.out.println(calculate.getAvg());
    }
}
