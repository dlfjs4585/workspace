package 다섯_반복문.For;

import java.util.Scanner;

/*
    while문에서의 무한루프
    while(true){

    }
    for문에서의 무한루프
    for(;;){

    }


*/


public class 무한루프 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("점수 입력 : ");
            int num = sc.nextInt();
            if (num >= 0 && num <= 100){
                break;
            }
        }
        System.out.println("무한루프에서 벗어났습니다.");






    }
}





















