
// 선수 학습
// inner class - 클래스 안에 선언된 클래스
// class 의 멤버(구성요소) : 멤버변수(필드), 메서드, 생성자, 클래스
// inner class 의 종류
// 1. 멤버 inner class : 멤버변수의 선언 위치와 같은 위치에 만들어진 inner class
// 2. 로컬 inner class : 지역변수의 선언 위치와 같은 위치에 만들어진 inner class
// 3. 익명 inner class (람다의 출발 지점)
public class Outer {

    private int num;

    public Outer(){
        this.num = 0;
    }

    // 멤버 inner class
    class Board{
        public void printNum(){
            System.out.println("num = " + num);
        }
    }

    // 메서드
    public void aaa(){
        int age = 12; // 지역변수

        // 로컬 inner class
        class Item{

            public void printAge(){
                System.out.println("age = " + age);
            }

        }

    }


}