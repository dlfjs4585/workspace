package object;

import 상속.MobilePhone;

public class TvTest {
    public static void main(String[] args) {

        Tv tv = new Tv();
        System.out.println(tv.modelName);
        tv.powerOn();

        //Object 클래스는 모든 클래스의 부모클래스이다.
        //자료형이 다르면 데이터 저장 불가능.
        //다형성에 의해서 부모클래스로 자식클래스 객체를 저장 할 수 있다.

        Object o1 = new Tv();
        Object o2 = new MobilePhone();
    }
}
