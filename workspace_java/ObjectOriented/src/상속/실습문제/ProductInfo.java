package 상속.실습문제;

import java.util.Scanner;

public class ProductInfo {
    public static void main(String[] args) {
        Product product = new Product();
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning){
            System.out.print("상품 추가<1>, 모든 상품 조회<2>, 끝내기<3>>>");
            int menu = sc.nextInt();

            switch (menu){
                case 1 :

                case 2 :

                case 3 :
            }




        }

    }
}
