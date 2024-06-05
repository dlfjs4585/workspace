package 여섯_배열;

import java.util.Arrays;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[] = new int[5];

        for (int i = 0; i < arr1.length; i++){
            System.out.print(i + "번째 요소 입력 : ");
            arr1[i] = sc.nextInt();

        }
        System.out.println("-배열에 저장된 요소-");
        for (int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int e : arr1){
            System.out.println(e);
        }
    }
}
