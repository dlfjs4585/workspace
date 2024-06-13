package Interface.array;

public class MyArray implements MyArrayUtil{

    @Override
    public double getTwoArrayAvg(int[] arr1, int[] arr2) {
        double result1 =0.0;
        double result2 =0.0;
        for (int i = 0; i < arr1.length; i++){
            result1 = result1 + (arr1[i] * (double)arr1.length);
        }
        for (int i = 0; i < arr2.length; i++){
            result2 = result2 + (arr2[i] * (double)arr2.length);
        }


        return (result1+result2)/2;
    }

    @Override
    public boolean isEvenArray(int[] array) {
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){

            }

        }

        return false;
    }
}
