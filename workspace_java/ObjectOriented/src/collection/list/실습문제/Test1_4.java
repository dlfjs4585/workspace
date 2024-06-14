package collection.list.실습문제;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test1_4 {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();

        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        list1.add((int) ((Math.random()*100)+1));
        int cnt = 0;

        for (int i = 0; i < list1.size(); i++){
            if (list1.get(i) % 2 == 0){
                cnt++;
                System.out.println(list1.get(i));
            }

        }
        System.out.println(cnt);



    }
}
