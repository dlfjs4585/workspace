package 상속.실습문제;

public class Product {
    String identifier; //식별자
    String explanation; //상품 설명
    String producer; //생산자
    int price; //가격



}

class Book extends Product{
    String isbnNum; //ISBN번호
    String writer; //저자
    String bookName; //책 제목
}

class CompactDisc extends Product{
    String albumName; //앨범 제목
    String singerName; // 가수 이름

}

class ConversationBook extends Book{
    String language; // 언어
}
