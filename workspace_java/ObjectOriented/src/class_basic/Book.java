package class_basic;

public class Book {
    String title;
    private String writer;
    private int price;

    public Book(){
        this.title = "";
        this.writer = "";
        this.price = 0;
    }

    public Book(String title, String writer, int price) {
        this.title = title;
        this.writer = writer;
        this.price = price;
    }
}
