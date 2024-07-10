package test;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("1~999사이의 정수를 입력하시오 : ");
        int num = sc.nextInt();
        int num1 = num / 100;
        int tens = (num%100) / 10;
        int ones = (num%100) % 10;
        int clapCnt = 0;

        if (num1 == 3 || num1 == 6 || num1 == 9){
            clapCnt++;
        }
        if (tens == 3 || tens == 6 || tens == 9){
            clapCnt++;
        }
        if (ones == 3 || ones == 6 || ones == 9){
            clapCnt++;
        }
        switch (clapCnt){
            case 1 :
                System.out.println("박수짝");
                break;
            case 2 :
                System.out.println("박수짝짝");
                break;
            case 3 :
                System.out.println("박수짝짝짝");
        }




    }
}
