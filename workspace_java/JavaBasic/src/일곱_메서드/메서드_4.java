package 일곱_메서드;

public class 메서드_4 {
    public static void main(String[] args) {
        introduce("자바", 20, "울산");

        String a = "홍";
        int b = 40;
        String c = "서울";

        introduce(a,b,c);

    }

    public static void introduce(String name, int age, String addr){ //매개변수는 ,(쉼표)를 이용하여 여러개 넣을 수 있음

        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + addr);

    }


}
