import java.util.Optional;

public class Optional_4 {
    public static void main(String[] args) {

        Optional<String> op = Optional.ofNullable(null);

        // map() 함수의 이어서 orElse 를 사용하면
        // 데이터가 null 일때, 실행 내용을 작성할 수 있음
        // 주의사항 : orElse() 메서드까지 사용하면 return 타입은 optional 이 아니라
        // 데이터가 리턴된다.
        String result = op.map( s -> s.toString() ).orElse("empty data");
        System.out.println(result);




    }
}
