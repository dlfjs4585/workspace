package 여섯_배열;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] array = {5,3,2,4,6,1};
        int max = 0;
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length-1; j++){
                if(array[j] > array[j+1]){
                    max = array[j];
                    array[j] = array[j+1];
                    array[j+1] = max;
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }
}
