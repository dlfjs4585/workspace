package collection.list.실습문제;

import java.util.ArrayList;
import java.util.List;

public class Test1_1 {
    public static void main(String[] args) {

        List<String > list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        for (int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }

    }
}
