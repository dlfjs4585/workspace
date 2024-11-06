public class OuterTest {
    public static void main(String[] args) {

        // inner class 사용방법
        // Outer 클래스 객체 생성
        Outer outer = new Outer();

        // Board 클래스 객체 생성
        Outer.Board board = outer.new Board();
        board.printNum();
    }
}
