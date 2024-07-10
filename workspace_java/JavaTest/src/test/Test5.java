package test;

import java.util.Random;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num1 = new int[3];
        int[] num2 = new int[3];
        int strike = 0;
        int ball = 0;
        int cnt = 1;

        for (int i = 0; i < num1.length; i++){
            num1[i] = (int)(Math.random()*9)+1;
            for (int j = 0; j < i; j++){
                if (num1[i] == num1[j]){
                    i--;
                    break;
                }
            }
        }

        while (true){
            for (int i = 0; i < num2.length; i++){
                System.out.print("1~9까지의 숫자를 입력하시오 : ");
                num2[i] = sc.nextInt();
                for (int j = 0; j < i; j++){
                    if (num2[i] == num2[j]){
                        i--;
                        break;
                    }
                }
            }

            for (int i = 0; i < num1.length; i++){
                for (int j = 0; j < num2.length; j++){
                    if (num1[i] == num2[j] && i == j){
                        strike++;
                    }
                    else if (num1[i] == num2[j] && i != j) {
                        ball++;
                    }
                }
            }

            System.out.println(cnt++ + " >> "  + strike + "스트라이크" + ball + "볼");
            if (strike == 3){
                System.out.println(cnt-1 + "회만에 정답을 맞췄습니다.");
                break;
            }

            strike = 0;
            ball = 0;


        }




    }
}
