package 일곱_메서드;

public class 메서드_5 {
    public static void main(String[] args) {
        int result = test1(1,4);
        System.out.println(result);

        System.out.println(test1(1, 7));
    }

    //매개변수로 전달된 두 정수의 합을 리턴하는 메서드

    public static int test1(int a, int b){
        return a + b;
    }



}
