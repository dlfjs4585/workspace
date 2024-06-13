package Interface.math;

public class MyMath implements MathUtil{
    int max;
    int min;
    @Override
    public int getMin(int a, int b) {
        if (a > b){
            max = a;
            min = b;
        }
        else {
            max = b;
            min = a;
        }
        return min;
    }

    @Override
    public double getCircleArea(int radius) {
        if (radius < 0){
            return 0;
        }
        else {
            return 2 * Math.PI * radius;
        }
    }

    @Override
    public int getMultiple(int num1, int n) {
        int result = 1;
        for (int i = 0; i < n; i++){
            result = result * num1;
        }

        return result;
    }
}
