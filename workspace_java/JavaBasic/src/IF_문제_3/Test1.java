package IF_문제_3;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 변의 길이 : ");
        int num1 = sc.nextInt();
        System.out.println("두번째 변의 길이 : ");
        int num2 = sc.nextInt();
        System.out.println("세번째 변의 길이 : ");
        int num3 = sc.nextInt();

        if (num1 + num2 > num3 && num2 + num3 > num1 && num1 + num3 > num2){
            System.out.println("삼각형 가능");
        }

        else{
            System.out.println("삼각형 불가능");
        }
    }
}
