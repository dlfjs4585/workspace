package test;

public class Test3 {
    public static void main(String[] args) {

        int[] arr1 = {5, 11, 20, 40, 30};
        int max = arr1[0];
        int min = arr1[0];
        for (int i = 0; i < arr1.length; i++){
            if (max < arr1[i]){
                max = arr1[i];
            }
        }
        for (int i = 0; i < arr1.length; i++){
            if (min > arr1[i]){
                min = arr1[i];
            }
        }
        System.out.println(max);
        System.out.println(min);

    }
}
