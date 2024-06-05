package 일곱_메서드;

public class Test1_15 {
    public static void main(String[] args) {
        test1(2,4);
    }

    public static void test1(int a, int b){

        if (a % 2 ==0 && b % 2 ==0 ){
            System.out.println("두 수는 짝수입니다.");
        }
        else if (a % 2 == 0 || b % 2 == 0 ) {
            System.out.println("한 수만 짝수입니다.");
        }
        else {
            System.out.println("두 수는 홀수입니다.");
        }

    }


}
