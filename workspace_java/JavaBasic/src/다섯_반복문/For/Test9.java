package 다섯_반복문.For;

public class Test9 {
    public static void main(String[] args) {
        int i = 0, k = 0;
        for (i = 1; i < 100; i++){

            if (i % 7 == 0 || i % 9 == 0){
                System.out.println(i);

            }

        }
    }
}
