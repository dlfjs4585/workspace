package 세번째_연산자;

import javax.xml.transform.Source;
import java.util.Scanner;

public class 연습문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("당신의 이름, 국어점수, 영어점수, 수학점수와 총점 및 평균을 입력하세요.");

        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("국어점수 : " );
        int kor = sc.nextInt();
        System.out.print("영어점수 : " );
        int eng = sc.nextInt();
        System.out.print("수학점수 : " );
        int math = sc.nextInt();
        System.out.println("당신의 이름은 " + name);
        System.out.println("국어점수 : " + kor);
        System.out.println("영어점수 : " + eng);
        System.out.println("수학점수 : " + math);

        int all = kor + eng + math;
        double avg = all / 3.0;
        System.out.println("총점 : " + all );
        System.out.println("평균 : " + avg );






    }
}
