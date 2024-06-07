package class_basic;

public class Student {

    String name;
    int age;
    int score;

    //매개변수로 전달된 문서자열로 name 값을 변경하는 메서드
    public void setName(String name1){
        name = name1;
    }

    //나이를 변경하는 메서드
    public void setAge(int age1){
       age = age1;
    }



    public void introduce(){

        System.out.println("이름은 : " + name);
        System.out.println("나이는 : " + age);
        System.out.println("점수는 : " + score);
    }



}
