package 일곱_메서드;

public class Test2_6 {
    public static void main(String[] args) {
        System.out.println(test1(5));
    }





    public static String test1(int a){


        //문자열 -> 정수
        int num = Integer.parseInt("10"); // 10

        //정수 -> 문자열
        String b = String.valueOf(10); // "10"

        return "" + a;
    }

}
