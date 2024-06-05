package 일곱_메서드;

import java.util.Scanner;

public class Test1_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하시오 : ");
        String name = sc.next();
        System.out.print("나이를 입려하시오 : ");
        int age = sc.nextInt();
        System.out.print("주소를 입력하시오 : ");
        String addr = sc.next();
        test1(name, age, addr);
    }

    public static void test1(String name, int age, String addr){
        System.out.println("이름은 : " + name);
        System.out.println("나이는 : " + age);
        System.out.println("주소는 : " + addr);
    }



}
