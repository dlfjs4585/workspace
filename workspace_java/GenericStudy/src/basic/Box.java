package basic;

// Generic 문법이 적용된 무엇이든 저장하고 리턴할 수 있는 박스
// T : 정해지지 않는 자료형
// Box<T> : T 가 자료형이 아니라 자료형이 정해지지 않은 제네릭 문법임을 컴파일러에게 인지
// 자료형이 정해지지 않았기 때문에, Generic 이 적용된 클래스에서는
// 메서드 구현이 아주 제한적이다. -> Generic 클래스에서 원하는 기능 못 만듦. (Object 만 사용할 수 있음)
// 이러한 문제를 해결하기 위해 타입인자(T) 를 제한하는 문법을 사용! -> 타입제한
public class Box<T> {

    private T obj;

    // 어떤 데이터든 저장할 수 있는 메서드
    public void setData(T obj){
        this.obj = obj;
    }

    // 어떤 데이터든 리턴할 수 있는 메서드
    public T getData(){
        return obj;
    }

}


class MemberVO{
    private String id;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

}

