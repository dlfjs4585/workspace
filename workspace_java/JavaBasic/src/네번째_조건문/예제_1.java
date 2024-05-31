package 네번째_조건문;

import java.util.Scanner;

public class 예제_1 {
    public static void main(String[] args) {
        //키보드로 정수를 입력받아
        //입력받은 정수가 10보다 클때만 '10 보다 큽니다'

        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int num1 = sc.nextInt();
        if(num1 > 10){
            System.out.println("10 보다 큽니다.");
        }
        else if (num1 < 10) {
            System.out.println("10 보다 작습니다.");
        }
    }
}
