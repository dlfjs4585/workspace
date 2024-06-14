package collection.list.실습문제;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1_2 {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        Integer num1 = sc.nextInt();
        Integer num2 = sc.nextInt();
        Integer num3 = sc.nextInt();
        Integer num4 = sc.nextInt();
        list1.add(num);
        list1.add(num1);
        list1.add(num2);
        list1.add(num3);
        list1.add(num4);
        int sum = 0;
        for (int i = 0; i < list1.size(); i++){
            sum = sum + list1.get(i);
        }
        System.out.println(sum);

    }
}
