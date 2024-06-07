package 일곱_메서드;

public class Test2_8 {
    public static void main(String[] args) {
        System.out.println(avg(1,2,3));
    }

    public static double avg(double a, double b, double c){
        double d = (a + b + c) / 3.0;
        return d;
    }

}
