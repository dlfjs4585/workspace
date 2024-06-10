package class_basic.calculator;

public class Calculator {
    private int num1;
    private int num2;

    public void setNumber(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }


    public int getSum(){
        return num1 + num2;
    }
    public int getSub(){
        return num1 - num2;
    }
    public int getMulti(){
        return num1 * num2;
    }
    public double getDiv(){
        return (double) num1 / num2;
    }





}
