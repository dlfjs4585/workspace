package test.member;

public class Member {
    private String name;
    private String id;
    private String pw;
    private int age;

    public void setInfo(String name, String id, String pw, int age){
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.age = age;
    }

    public void showInfo(){
        System.out.println("이름 : " + name);
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + pw);
        System.out.println("나이 : " + age);
    }

    public boolean isLogin(String id, String pw){
        if (this.id.equals(id) && this.pw.equals(pw)){
            System.out.println("로그인 가능");
        }
        else {
            System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
        }
        return true;
    }

}
