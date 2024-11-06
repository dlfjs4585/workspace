public class GetterableTest {
    public static void main(String[] args) {

        // 람다로 구현한 메서드의 내용 부분이 한 줄 이라면 {} 생략 가능
        Gettterable gettterable = () -> System.out.println(1111);
        gettterable.getNum();


    }
}