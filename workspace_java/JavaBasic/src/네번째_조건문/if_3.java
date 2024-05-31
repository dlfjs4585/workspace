package 네번째_조건문;

import java.util.Scanner;

public class if_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num1 = sc.nextInt();

        if (num1 > 0){
            System.out.println(1);
        }
        else if (num1 < 0){
            System.out.println(2);
        }
        else {
            System.out.println(3);
        }

    }
}


