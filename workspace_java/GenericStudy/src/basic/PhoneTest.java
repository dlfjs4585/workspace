package basic;

public class PhoneTest {
    public static void main(String[] args) {
        // PhoneBox 의 타입인자는
        // Phone, MobilePhone, SmartPhone 만 들어올 수 있음
        //PhoneBox<String> p1 = new PhoneBox<>(); -> 오류 발생
        //p1.phoneTest("phone");

        PhoneBox<Phone> box1 = new PhoneBox<>();
        PhoneBox<MobilePhone> box2 = new PhoneBox<>();
        PhoneBox<SmartPhone> box3 = new PhoneBox<>();






    }
}
