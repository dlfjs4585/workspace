package object;

public class String_4 {
    public static void main(String[] args) {

        String a = "짜장면";
        String b = "짬뽕";

        //concat : 두 문자열을 나열
        System.out.println(a.concat(b));
        //substring : 문자열 일부 추출
        String str1 = "abcdefg";
        System.out.println(str1.substring(2)); // 2번째 문자열부터 추출 하겠다.
        System.out.println(str1.substring(2,4)); //시작은 포함(<=), 끝은 포함x(<)
        //length : 문자열 길이를 알려줄
        String str2 = "잠온다";
        System.out.println(str2.length());

        String str3 = "피자,치킨,족발";
        String[] result =str3.split(",");
        System.out.println(result[2]);




    }
}
