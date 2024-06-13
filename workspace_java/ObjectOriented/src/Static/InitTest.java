package Static;

public class InitTest {
    public static void main(String[] args) {

        StaticInit i1 = new StaticInit();
        StaticInit i2 = new StaticInit();
        StaticInit i3 = new StaticInit();

        //static 변수를 읽고 사용하는 방법
        //객체명.변수명으로 static 변수도 사용가능. 추천하지 않는 방법
        System.out.println(i1.num);
        System.out.println(i2.num);

        //static 변수 및 메서드는
        //클래스명.변수명으로 접근한다.
        //이러한 접근 방법은 객체를 만들지 않아도 사용가능
        //객체를 생성하기 전에 static 변수를 먼저 확인하기 때문에.
        System.out.println(StaticInit.num);

        //객체명.메서드명
        //클래스명.메서드명이면 static 사용
        Math.random();



    }
}
