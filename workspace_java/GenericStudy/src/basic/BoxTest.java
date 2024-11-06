package basic;

public class BoxTest {
    public static void main(String[] args) {

        // Generic 문법이 적용된 클래스는 클래스 구현 시 자료형을 지정하지 않았다.
        // Generic 문법이 적용된 클래스의 자료형은 객체 생성 시 결정해야 함.
        // Box 객체 생성
        Box<String> box1 = new Box<>();
        box1.setData("aaa");
        String data1 = box1.getData();

        Box<Integer> box2 = new Box<>();
        box2.setData(6);

        Box<Apple> box3 = new Box<>();
        box3.setData(new Apple());

        System.out.println(box3.getData());

        // MemberVO를 저장할 수 있는 Box 생성
        Box<MemberVO> box4 = new Box<>();
















    }
}