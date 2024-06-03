package 네번째_조건문;

import javax.swing.text.html.CSS;
import java.util.Scanner;

public class Switch_예제_1 {
    public static void main(String[] args) {

        System.out.print("정수를 입력하시오 : ");

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        switch (num % 2){
            case 0 :
                System.out.println(1);
                break;
            case 1 :
                System.out.println(2);
                break;
            default:
                System.out.println(0);
        }



    }
}
