package class_basic.stu_manage;

import com.sun.source.tree.IfTree;

public class Stu {

    private String name;
    private int age;
    private String grade;
    private String tel;

    public Stu(String name, int age, String grade, String tel) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.tel = tel;
    }

    //학생의 모든 정보 출력
    public void showInfo(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("학점 : " + grade);
        System.out.println("연락처 : " + tel);
    }
    public String getName(){
        return name;
    }



}
