package 여섯_배열;

import java.util.Arrays;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("값을 입력하시오 : ");
        int arr1[] = new int[5];

        for (int i = 0; i < arr1.length; i++){

            int num1 = sc.nextInt();
            arr1[i] = num1;
        }
        System.out.println(Arrays.toString(arr1));

    }
}
