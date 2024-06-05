package 일곱_메서드;

public class Test1_17 {
    public static void main(String[] args) {
        test1(9, 4);
    }

    public static void test1(int a, int b){

        int max = a > b ? a : b;
        int min = a < b ? a : b;

//        int max;
//        int min;
//
//        if (a > b){
//            max = a;
//            min = b;
//        }
//        else{
//            max = b;
//            min = a;
//        }
        for (int i = min +1; i < max; i++){

            System.out.println(i);
        }

    }


}
