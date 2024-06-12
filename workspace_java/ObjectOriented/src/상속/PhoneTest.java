package 상속;

public class PhoneTest {
    public static void main(String[] args) {

        MobilePhone mb = new MobilePhone();
        SmartPhone sp = new SmartPhone();

        //부모클래스로는 자식 클래스이 객체를 받을 수 있음.
        //다형성으로 생성된 객체는 부모클래스의 변수, 메서드만 사용 가능
        MobilePhone mb1 = new SmartPhone();
        //m2.playApp(); 오류
        //SmartPhone sp1 = MobilePhone();    오류!
        mb1.sendMsg();

    }
}
