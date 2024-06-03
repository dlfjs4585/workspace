package 네번째_조건문;

import java.util.Scanner;

public class Switch_예제_2 {
    public static void main(String[] args) {

        System.out.print("주민등록번호 7번째 자리를 입력하시오 : ");

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        switch (num){

            case 1, 3 :
                System.out.println("남성");
                break;
            case 2, 4 :
                System.out.println("여성");
                break;
            default:
                System.out.println("오류");


        }

    }
}
