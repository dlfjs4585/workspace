package 일곱_메서드;

import java.util.Scanner;

public class Test1_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        test1(x,y);
    }

    public static void test1(int num1, int num2){
        System.out.println(num1 + num2);
    }


}
