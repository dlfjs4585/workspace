package JavaTest.Calculate;

public class Calculate {

    private int num1;
    private int num2;

    public void setNumber(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getSum() {
        return num1 + num2;
    }

    public int getMax() {
        int max = 0;
        if (num1 > num2) {
            max = num1;
        } else {
            max = num2;
        }
        return max;
    }

    public double getAvg() {
        int sum = 0;
        int cnt = 0;
        int max = 0;
        int min =  0;
        if (num1 > num2) {
            max = num1;
            min = num2;
        }
        else {
            max = num2;
            min = num1;
        }

        for (int i = min + 1; i < max; i++) {
            sum = sum + i;
            cnt++;
        }

        return (double)sum / cnt;
    }

}
