package 상속;

public class ManTest {
    public static void main(String[] args) {

        BusinessMan b1 = new BusinessMan();
        System.out.println(b1.company);
        b1.tellCompany();
        System.out.println(b1.name);
        b1.tellName();


    }
}
