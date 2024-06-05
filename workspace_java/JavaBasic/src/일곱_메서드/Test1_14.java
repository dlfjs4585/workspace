package 일곱_메서드;

public class Test1_14 {
    public static void main(String[] args) {
        test1(3);
    }

    public static void test1(int i){
        //삼항연산자
        // int a = 10 > 5 ? 1 : 2;

        if (i % 2 == 0){
            System.out.println("짝수입니다.");
        }
        else {
            System.out.println("홀수입니다.");
        }
        System.out.println(i % 2 == 0 ? "짝수" : "홀수");
    }
}
