package 일곱_메서드;

public class Test1_6 {
    public static void main(String[] args) {
        test1(1, 2, 3);
    }

    public static void test1(int a, int b, int c){
        int num1 = a * b * c;
        System.out.println("정수를 세 개의 곱은 : " + num1);
    }
}
