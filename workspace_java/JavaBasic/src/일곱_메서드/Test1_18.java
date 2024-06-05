package 일곱_메서드;

public class Test1_18 {
    public static void main(String[] args) {
        test1(10, 80);
    }

    public static void test1(int a, int b){

        int max;
        int min;
        int cnt = 0;
        if (a > b){
            max = a;
            min = b;
        }
        else{
            max = b;
            min = a;
        }

        for (int i = min +1; i < max; i++){


            if (i % 5 == 0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
