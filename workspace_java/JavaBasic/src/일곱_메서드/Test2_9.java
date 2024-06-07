package 일곱_메서드;

public class Test2_9 {
    public static void main(String[] args) {
        System.out.println(test1(5));
    }

    public static int test1(int a){
        int sum = 0;
        for (int i = 0; i <= a; i++){
            if (i % 2 != 0){
                sum = sum + i;
            }
        }
        return sum;
    }

}
