package collection.list.실습문제;

import java.util.ArrayList;
import java.util.List;

public class Test1_5 {

}

class TestMember{
    public static void main(String[] args) {
        List<Member>member = new ArrayList<>();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();

        member1.setId("java");
        member1.setPassword("1234");
        member1.setName("김");
        member1.setAge(14);

        member2.setId("park");
        member2.setPassword("1234");
        member2.setName("박");
        member2.setAge(15);

        member3.setId("lee");
        member3.setPassword("1234");
        member3.setName("이");
        member3.setAge(17);


        member.add(member1);
        member.add(member2);
        member.add(member3);

        for (int i = 0; i < member.size(); i++){
            System.out.println(member.get(i));
        }

        System.out.println();

        int sum = 0;
        for (int i = 0; i < member.size(); i++){
            sum = sum + member.get(i).getAge();
        }
        System.out.println(sum);

        System.out.println();
        for (int i = 0; i < member.size(); i++){
            if (member.get(i).getId().equals("java")){
                member.remove(i).getId();
            }
        }
        for (int i = 0; i < member.size(); i++){
            System.out.println(member.get(i));
        }

    }
}

class Member{
    String id;
    String password;
    String name;
    int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
