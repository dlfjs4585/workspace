import java.util.Optional;

public class Optional_1 {
    public static void main(String[] args) {

        String str = null;

        // 객체를 Optional 상자에 넣기
        // of() 메서드에는 null 들어가면 오류 발생
        //Optional<String> op1 = Optional.of(str); // null 을 허용하지 않을 객체
        Optional<String> op2 = Optional.ofNullable(str); // null 을 허용하는 객체

        // isPresent() : 상자의 데이터가 존재하는지 확인
        if(op2.isPresent()){
            System.out.println(op2.get()); // Optional 상자의 데이터 읽기
        }



    }
}
