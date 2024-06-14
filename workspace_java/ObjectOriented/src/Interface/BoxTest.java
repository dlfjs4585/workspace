package Interface;


//wrapper클래스 : 기본 자료형을 클래스로 표현한 것.
//wrapper클래스는 기본자료형 처럼 사용하면 된다. ex) Integer num = 10;
//int -> Integer
//double -> Double
//boolean -> Boolean
//float -> Float
public class BoxTest {
    public static void main(String[] args) {
        //정수 10를 클래스화
        Integer a = Integer.valueOf(10);
        Integer b = 10;
        Box box = new Box();
        box.setBox(10); // 10 -> Integer
        box.setBox(a);
    }
}
