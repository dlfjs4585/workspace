package test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하시오 : ");
        int num1 = scanner.nextInt();
        System.out.print("정수를 입력하시오 : ");
        int num2 = scanner.nextInt();
        System.out.print("정수를 입력하시오 : ");
        int num3 = scanner.nextInt();

        if (num1 > num2 && num1 > num3){
            if (num2 > num3){
                System.out.println(num1 + ", " + num2 + ", " + num3);
            }
            else {
                System.out.println(num1 + ", " + num3 + ", " + num2);
            }
        }
        else if (num2 > num1 && num2 > num3) {
            if (num1 > num3){
                System.out.println(num2 + ", " + num1 + ", " + num3);
            }
            else {
                System.out.println(num2 + ", " + num3 + ", " + num1);
            }
        }
        else if (num3 > num1 && num3 > num2) {
            if (num1 > num2){
                System.out.println(num3 + ", " + num1 + ", " + num2);
            }
            else {
                System.out.println(num3 + ", " + num2 + ", " + num1);
            }
        }
        else{
            System.out.println("중복은 없음");
        }

    }
}
