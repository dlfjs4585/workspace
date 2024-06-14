package collection.list.실습문제;

import java.util.ArrayList;
import java.util.List;

public class Test1_3 {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();

        list1.add("kim");
        list1.add("홍길동");
        list1.add("kim");

        for (int i = 0; i < list1.size(); i++){
            if (list1.get(i).equals("홍길동 ")){
                System.out.println("해당 이름이 존재합니다.");
            }
        }

    }
}
