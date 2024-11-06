public class LambdaPracticeTest {
    public static void main(String[] args) {

        // 1. 람다를 이용해서 LambdaPractice 인터페이스 안의
        // printName 메서드의 기능을 "홍길동입니다"가
        // 출력될 수 있도록 구현 및 확인하기

        LambdaPractice lambdaPractice = () -> System.out.println("홍길동입니다");
        lambdaPractice.printName();

        // 매개변수의 자료형은 생략, 매개변수명은 마음대로 가능
        // 매개변수가 하나일 때, 소괄호 생략가능
        LambdaPractice1 lambdaPractice1 = name -> System.out.println("이름은 = " + name);
        lambdaPractice1.printName("김길동");

        LambdaPractice2 lambdaPractice2 = (name, age) -> System.out.println("이름은 = " + name + ", " + "나이는 = " + age);
        lambdaPractice2.printMyInfo("박길동", 15);

        // return type 이 있는 람다식은 중괄호 생략 불가능.
        // 중괄호를 생략하려면 'return' 이라는 키워드로 같이 생략
        LambdaPractice3 lambdaPractice3 = () -> 3333;
        System.out.println(lambdaPractice3.getNum());

        LambdaPractice4 lambdaPractice4 = (a, b) -> a + b;
        System.out.println(lambdaPractice4.getResult(10,20));


    }
}
