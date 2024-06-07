package 일곱_메서드;

import java.util.Scanner;

public class Test2_2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(test1(a,b));
    }

    public static int test1(int a, int b){

        return a * b;


    }



}
