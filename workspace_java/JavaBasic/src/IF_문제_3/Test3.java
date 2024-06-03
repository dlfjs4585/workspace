package IF_문제_3;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1~99 사이의 정수를 입력하시오>>");
        int num1 = sc.nextInt();
        int tens = num1 / 10; //십의 자리
        int ones = num1 % 10; //일의 자리
        int clapCnt = 0; //박수 횟수
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
        }
    }
}

