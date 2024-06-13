package object;

public class Person {
    String name;
    int age;

    //부모클래스의 메서드를 overriding하고 있는 것
    //overriding이 되려면 메서드명 일치, 매개변수 정보 일치, 리턴 타입 일치


    @Override
    public boolean equals(Object obj) {

        if (name.equals(((Person)obj).name) && age == ((Person)obj).age){
            return true;
        }
        else {
            return false;
        }
    }

    //toString() overriding
    //객체를 문자열로 표현 -> 모든 맴버변수의 값을 문자열로 표현


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
