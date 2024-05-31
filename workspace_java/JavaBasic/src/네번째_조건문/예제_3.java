package 네번째_조건문;

import java.util.Scanner;

public class 예제_3 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num1 = sc.nextInt();


        if (num1 % 3 == 0 && num1 % 5 == 0){
            System.out.println(1);
        }



    }
}
