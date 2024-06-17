package 여섯_배열;


import java.util.Scanner;

public class Test2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하시오 : ");
        int i = sc.nextInt();
        int arr1[] = new int[i];
        int sum = 0;

        for (i = 0; i < arr1.length; i++){
            arr1[i] =i+1;
            System.out.print(arr1[i] + " ");
        }

        for (int e : arr1){
            sum = sum + e;
        }
        System.out.println(sum / (double)arr1.length);





    }
}
