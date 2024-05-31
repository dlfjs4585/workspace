package 변수와자료형;/*
    변수는 데이터를 저장하기 위한 공간
    변수 사용을 위해서는 변수를 선언부터 하여야 한다.
    변수의 선언 문법은 [자료형 변수명;]
    변수는 원하는 만큼 개수 제한없이 선언 가능
    변수 각각의 이름은 중복 불허!(대소문자 구분함)
    하나의 변수에는 하나의 값만 저장할 수 있다.
    ------------------------------------------------------------
    변수명의 명명법
    변수는 소문자로 선언(관례)
    변수는 예약어, 지정어를 사용할 수 없다.
    변수는 한글로 선언 가능하지만 영어를 권장
    변수의 이름은 직관적인것이 좋다.
    복합어의 변수는 camelCase 기법으로 선언
*/


public class 변수_2 {
    public static void main(String[] args) {
        int num1;
        int num2;
        num1 = 10;
        num2 = 20;
        int num3;
        num3 = num1 + num2;
        System.out.println("num1 = " + num1);
        System.out.println(num2);
        System.out.println(num3);


    }
}
