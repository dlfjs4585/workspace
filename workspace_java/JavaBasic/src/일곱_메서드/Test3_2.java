package 일곱_메서드;

public class Test3_2 {
    public static void main(String[] args) {
        test1(5);
    }

    public static void test1(int a){
        for (int i = 1; i <= 100; i++){
            if (i % a == 0){
                System.out.println(i);
            }
        }
    }


}
