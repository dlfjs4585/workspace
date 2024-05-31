package IF_문제_1;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();

        if (num1 % 2 == 0){
            System.out.println("짝수입니다.");
        }
        else {
            System.out.println("홀수입니다.");
        }
    }
}
