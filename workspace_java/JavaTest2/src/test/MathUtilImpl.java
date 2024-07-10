package test;

public class MathUtilImpl implements MathUtil{

    @Override
    public boolean isEven(int a, int b, int c) {
        if ((a+b+c)%2==0 && (a+b+c)%5==0 ){
        }
        return true;
    }

    @Override
    public int getSumFromOne(int num) {
        int sum = 0;
        for (int i = 0; i < num+1; i++){
            sum = sum + i;
        }
        return sum;
    }

    @Override
    public int getArraySum(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++){
            sum = sum + num[i];
        }
        return sum;
    }


}
