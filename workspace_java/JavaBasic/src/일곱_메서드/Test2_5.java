package 일곱_메서드;

public class Test2_5 {
    public static void main(String[] args) {
        System.out.println(test1(98));
    }

    //리턴타입과 매개변수를 잘 확인할 것.
    public static String test1(int a){
        if (a >= 90){
            return "A";
        }
        else if (a >= 70){
            return "B";
        }
        else {
            return "C";
        }
    }

}
