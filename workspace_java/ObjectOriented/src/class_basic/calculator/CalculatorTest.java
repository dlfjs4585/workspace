package class_basic.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 수 : ");
        int num1 = sc.nextInt();
        System.out.print("두번째 수 : ");
        int num2 = sc.nextInt();
        System.out.print("연산자 : ");
        String oper = sc.next();

        c1.setNumber(num1,num2);

        if (oper.equals("+")){
            System.out.print(num1 + " + " + num2 + " = " + c1.getSum());
        }
        else if(oper.equals("-")){
            System.out.print(num1 + " - " + num2 + " = " + c1.getSub());
        }
        else if (oper.equals("*")) {
            System.out.print(num1 + " * " + num2 + " = " + c1.getMulti());
        }
        else if (oper.equals("/")) {
            System.out.print(num1 + " / " + num2 + " = " + c1.getDiv());
        }
        else {
            System.out.println("연산자를 잘못입력하셨습니다.");
        }
    }
}
