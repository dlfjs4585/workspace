package 네번째_조건문;

import java.util.Scanner;

public class Switch_예제_3 {
    public static void main(String[] args) {

        System.out.print("점수를 입려하시오 : ");
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();
        int num = score / 10;
        switch (num){
            case 9, 10:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            default:
                System.out.println("D");
        }


    }
}
