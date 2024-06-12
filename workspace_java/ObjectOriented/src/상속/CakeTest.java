package 상속;

public class CakeTest {
    public static void main(String[] args) {

        CheeseCake c = new CheeseCake();
        c.eat(); //자식클래스에서 재정의한 메서드가 실행

        //c객체로부터 부모클래스에서 선언한 eat() 메서드를 호출 할 수 있나? 불가능



    }
}
