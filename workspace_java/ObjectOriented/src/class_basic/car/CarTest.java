package class_basic.car;

public class CarTest {
    public static void main(String[] args) {

        Car c1 = new Car();

        //c1의 변수 출력
        System.out.println(c1.brand);
        System.out.println(c1.price);

        //c1 변수의 값 변경
        c1.brand = "현대";
        c1.price = 100;

        System.out.println(c1.brand);
        System.out.println(c1.price);

        System.out.println();

        Car c2 = new Car();
        c2.printCarInfo();
        c2.setBrand("기아");
        c2.setModelName("K3");
        c2.setCarNumber("1234");
        c2.setPrice(100);
        c2.setOwner("A");
        c2.printCarInfo();



    }
}
