package class_basic;

public class BookTest {
    public static void main(String[] args) {

        Book b1 = new Book("java", "kim", 1000);
        Book b2 = new Book("python","lee",2000);

        //class 또한 참조자료형이다!
        Book b3 = b1;
        System.out.println(b1.title);
        System.out.println(b3.title);
        b1.title = "c++";
        //b1에는 데이터 하나를 가진다.
        //데이터 하나에는 title,writer,price의 데이터를 보관하는 주소를 가지고있다.
        //그래서 b3에는 같은 주소값이므로 "c++"이 도출된다.
        System.out.println(b1.title);
        System.out.println(b3.title);



    }
}
