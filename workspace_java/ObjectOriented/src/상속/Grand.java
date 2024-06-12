package 상속;

//자바에서 다중상속은 가능한가?(부모클래스를 여러개 가질 수 있는가?)
//문법적으로는 ★★"불가능"★★, 논리적으로 가능(상속을 누적)
public class Grand {
    int a;
}

class Parent1 extends Grand{
    int b;
}

class Child1 extends Parent1 {
    int c;

    public void aaa(){
        System.out.println(a);
        System.out.println(b);
    }
}


