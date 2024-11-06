package basic;

public class GenericMethodTest {
    public static void main(String[] args) {

        // Generic 메서드의 자료형은 메서드 호출 시 결정
        Box<String> b1 = GenericMethod.<String>makeBox("문자열");
        Box<Integer> b2 = GenericMethod.<Integer>makeBox(5);

        Box<String> box1 = new Box<>();

        GenericMethod.peekBox(box1);

        GenericMethod.peekBox1(b1);
        GenericMethod.peekBox1(b2);


    }
}
