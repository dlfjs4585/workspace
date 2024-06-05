package 여섯_배열;

public class Test2_6 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};
        int[] newArr = new int[arr1.length + arr2.length];

        for (int i =0; i < arr1.length; i++){
            newArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++){
            newArr[i + arr1.length] = arr2[i];
        }
        for (int e : newArr){
            System.out.print(e + " ");
        }


    }
}
