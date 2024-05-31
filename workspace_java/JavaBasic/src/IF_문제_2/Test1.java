package IF_문제_2;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max;
        int min;

        System.out.print("첫번째 수 :");
        int num1 = sc.nextInt();
        System.out.print("두번째 수 :");
        int num2 = sc.nextInt();

        if (num1 > num2 ) {
            max = num1;
            min = num2;
        }
       else {
           max = num2;
           min = num1;
        }
        System.out.println(max + " > " + min);
    }
}