package 일곱_메서드;

public class Test3_6 {
    public static void main(String[] args) {
        int[] num = {1,3,5,7,9};
        System.out.println(test1(num));
    }

    public static int test1(int[] a){
        int max = 0;
        for (int i = 0; i < a.length; i++){
            if (max < a[i]){
                max = a[i];
            }
        }
        return max;
    }



}
