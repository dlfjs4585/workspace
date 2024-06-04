package 다섯_반복문.For;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫번째 정수를 입력하시오 : ");
        int i = sc.nextInt();
        System.out.print("두번째 정수를 입력하시오 : ");
        int j = sc.nextInt();

        //큰 수, 작은 수 구분
        int max, min;
        if(i > j){
            max = i;
            min = j;
        }
        else{
            max = j;
            min = i;
        }
        int sum = 0;
        for (int num1 = i +1; num1 < j; num1++){
            sum = sum + 1;
        }


    }
}
