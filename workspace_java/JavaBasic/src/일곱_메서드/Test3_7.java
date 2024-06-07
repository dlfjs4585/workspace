package 일곱_메서드;

public class Test3_7 {
    public static void main(String[] args) {
        String[] a = {"j","a","v","a"};
        System.out.println(test1(a));

    }
    //문자열을 나열 = 정수형에서 sum과 같다.
    public static String test1(String[] a){
        String result = "";
        for (int i = 0; i < a.length; i++){
            result = result +a[i];
        }
        return result;
    }

}
