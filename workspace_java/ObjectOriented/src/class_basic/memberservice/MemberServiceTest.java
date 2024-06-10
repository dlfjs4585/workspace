package class_basic.memberservice;

public class MemberServiceTest {
    public static void main(String[] args) {

        MemberService m1 = new MemberService();
        boolean result = m1.login("hong","12345");
        if (result){
            System.out.println("로그인 되었습니다.");
            m1.logout("hong");
        }
        else {
            System.out.println("id 또는 password가 올바르지 않습니다.");
        }
    }
}
