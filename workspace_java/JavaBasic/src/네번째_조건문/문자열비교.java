package 네번째_조건문;

import java.util.Scanner;

public class 문자열비교 {
    public static void main(String[] args) {


        String s1 = "java";
        String s2 = "python";

        System.out.println(s1 == s2); //문자열 비교아님!, 시험나옴
        System.out.println("1" == "1");//문자열 비교아님!!

        String name = "kim";
        //name 변수의 값이 "kim"이랑 같은가?
        boolean result = name.equals("kim");
        System.out.println(result);

//        String addr = "울산";
//        if (addr.equals("울산")){
//
//
//        }


        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 수 : ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 수 : ");
        int num2 = sc.nextInt();
        System.out.print("연산자 : ");
        String i = sc.next();


        if (i.equals("*")){
            System.out.println(num1 + i + num2 + " = " + (num1*num2));
        }
        else if (i.equals("/")){
            System.out.println(num1 +  i + num2 + " = " + (num1/(double)num2));
        }
        else if (i.equals("-")){
            System.out.println(num1 + i + num2 + " = " + (num1 - num2));
        }
        else if (i.equals("+")){
            System.out.println(num1 + i + num2 + " = " + (num1 + num2) );
        }
        else {
            System.out.println("연산자를 잘못 입력하셨습니다.");
        }


        switch (i){
            case "*":
                System.out.println(num1 + i + num2 + " = " + (num1*num2));
                break;
            case "/":
                System.out.println(num1 + i + num2 + " = " + (num1/(double)num2));
                break;
            case "-":
                System.out.println(num1 + i + num2 + " = " + (num1-num2));
                break;
            case "+":
                System.out.println(num1 + i + num2 + " = " + (num1*num2));
                break;
            default:
                System.out.println("연산자를 잘못 입력하셨습니다.");
        }


    }
}
