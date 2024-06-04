package 다섯_반복문.For;

public class Test7 {
    public static void main(String[] args) {
        int cnt = 0;

        for (int i = 1; i < 101; i++){
            if (i % 5 == 0){
                System.out.println(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
