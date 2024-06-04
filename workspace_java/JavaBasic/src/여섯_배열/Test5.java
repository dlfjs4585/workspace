package 여섯_배열;

public class Test5 {
    public static void main(String[] args) {
        int arr1[] = {1, 5, 7};
        int sum = 0;
        for (int i = 0; i < arr1.length; i++){
            sum = sum + arr1[i];

        }
        System.out.println("배열의 모든 요소의 합은 : " + sum);
    }
}
