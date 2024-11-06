package basic;

// 좋은 코딩은 컴파일 오류가 많이 나는 코드
// 컴파일 오류 : 코드를 실행하기 전에 발생하는 오류, 빨간줄로 표시 됨
// 런타임 오류 : 코드를 실행하면 발생하는 오류

// Generic 을 사용하지 않았을 때 단점
// 1. 데이터를 리턴받을 때 매번 형변환 작업을 해야한다.
// 2. 개발자의 실수로 발생하는 런타임 오류를 작성할 확률이 높다.
public class BeforeBoxTest {
    public static void main(String[] args) {
        // BeforeBox 객체 생성
        BeforeBox box1 = new BeforeBox();

        box1.setData("apple");

        BeforeBox box2 = new BeforeBox();

        box2.setData(1);

        BeforeBox box3 = new BeforeBox();

        box3.setData(new Apple());

        BeforeBox box4 = new BeforeBox();

        box4.setData(new Orange());

        // box1에 저장된 데이터를 받아오기
        String data1 = (String) box1.getData();
        System.out.println(data1);

        int data2 = (int) box2.getData();

        Apple data3 = (Apple) box3.getData();

        // Orange data4 = (Orange) box3.getData();

        System.out.println(data2);
        System.out.println(data3);
    }
}
