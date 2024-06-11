package class_basic.multiclass;

import java.util.Scanner;

public class MultiClassTest {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        Sub s1 = new Sub();
        Add a1 = new Add();
        Mul m1 = new Mul();
        Div d1 = new Div();

        System.out.print("첫 번째 수 : ");
        int a = sc.nextInt();
        System.out.print("두 번째 수 : ");
        int b = sc.nextInt();
        System.out.print("연산자 : ");
        String oper = sc.next();

        s1.setValue(a,b);
        a1.setValue(a,b);
        m1.setValue(a,b);
        d1.setValue(a,b);

        if (oper.equals("+")){
            System.out.println(a + " + " + b + " = " + a1.calculate());
        }
        else if (oper.equals("-")) {
            System.out.println(a + " - " + b + " = " + s1.calculate());
        }
        else if (oper.equals("*")){
            System.out.println(a + " * " + b + " = " + m1.calculate());
        }
        else if (oper.equals("/")){
            System.out.println(a + " / " + b + " = " + d1.calculate());
        }
        else {
            System.out.println("연산자를 잘못입력하셨습니다.");
        }


    }
}
