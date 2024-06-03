package 다섯_반복문.While;

public class Test7 {
    public static void main(String[] args) {
        int i = 1;
        int cnt = 0;
        while (i <= 100){
            if (i % 5 == 0){
                System.out.println(i);
                cnt++;
            }
            i++;
        }
        System.out.println(cnt);
    }
}
