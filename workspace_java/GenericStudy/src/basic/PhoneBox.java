package basic;

// <T extends Phone> : T를 Phone 클래스 or Phone 클래스를 상속한 클래스만 허용하도록 타입인자를 제한
public class PhoneBox<T extends Phone> {
    private T data;

    public void phoneTest(T data){
        this.data = data;
        data.call();
    }

}
