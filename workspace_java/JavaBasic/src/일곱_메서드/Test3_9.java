package 일곱_메서드;

import java.util.Arrays;

public class Test3_9 {
    public static void main(String[] args) {
        int[] a = {1,2,8,6,3,10};
        int[] result = test1(a);
        System.out.println(Arrays.toString(result));
    }

    public static int[] test1(int[] a){
        //매개변수로 넘어온 배열 요소 중 짝수의 개수
        int cnt =0;
        for (int e : a){
            if (e % 2 == 0){
                cnt++;
            }
        }
        //짝수만 저장될 배열 생성
        int[] resultArr = new int[cnt];
        int index = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] % 2 == 0){
                resultArr[index] = a[i];
                index++;
            }
        }
        return resultArr;


    }



}
