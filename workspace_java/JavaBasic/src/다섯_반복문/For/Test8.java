package 다섯_반복문.For;

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하시오 : ");
        int i = sc.nextInt();
        int cnt = 0;

        for (int j = i; j >= 1; j-- ){
            if (j % 2 ==0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
