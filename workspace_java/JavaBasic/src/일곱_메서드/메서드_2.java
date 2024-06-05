package 일곱_메서드;

import java.io.ObjectOutputStream;

public class 메서드_2 {
    public static void main(String[] args) {
        System.out.println("시작~");
        tellYourName();
        tellYourAge();
        System.out.println("종료~");
    }

    public static void tellYourName(){
        System.out.println("제 이름은 Y입니다.");
    }

    public static void tellYourAge(){
        System.out.println("제 나이는 20살입니다.");
        tellYourAddr();
    }

    public static void tellYourAddr(){
        System.out.println("저는 울산에 살아요.");
    }


}
