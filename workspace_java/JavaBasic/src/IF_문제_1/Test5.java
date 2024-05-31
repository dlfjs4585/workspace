package IF_문제_1;

public class Test5 {
    public static void main(String[] args) {
        int num1 = 70;
        String grade;

        if (num1 > 90 && num1 <= 100){
            grade = "A";
        }
        else if (num1 > 80) {
            grade = "B";
        }
        else {
            grade = "C";
        }
        System.out.println(grade + "입니다.");
    }
}
