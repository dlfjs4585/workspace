package 다섯_반복문.While;

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오 : ");
        int i = sc.nextInt();
        int cnt  = 0;
        while (i >= 1){
            if (i % 2 == 0){
                cnt++;
            }
            i--;
        }
        System.out.println(cnt);
    }
}
