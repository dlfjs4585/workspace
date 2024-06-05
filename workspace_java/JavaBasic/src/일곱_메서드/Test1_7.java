package 일곱_메서드;

public class Test1_7 {
    public static void main(String[] args) {
        test1(5, 5);
    }

    public static void test1(int a, int b){
        int num1 = a / b;
        int num2 = a % b;
        System.out.println("두 정수의 몫은 : " + num1);
        System.out.println("두 정수의 나머지는 : " + num2);
    }





}
