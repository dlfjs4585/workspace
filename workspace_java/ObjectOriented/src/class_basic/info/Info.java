package class_basic.info;

public class Info {

    String name;
    String id;
    String password;
    int age;

    public void setInfo(String name1, String id1, String password1, int age1){
        name = name1;
        id = id1;
        password = password1;
        age = age1;
    }
    public void setName(String name1){
        name = name1;
    }

    public void printInfo(){
        System.out.println("이름 : " + name);
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + password);
        System.out.println("나이 : " + age);
    }


}
