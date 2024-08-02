import java.util.HashMap;
import java.util.Map;

public class Map_2 {
    public static void main(String[] args) {

        // 학생 객체 3명 생성 후
        Student student1 = new Student("이름1", 1);
        Student student2= new Student("이름2", 2);
        Student student3 = new Student("이름3", 3);
        // 3명의 학생을 map에 저장하시오.
        Map<Integer, Student> map = new HashMap<>();

        // 이때, key 는 각 학생의 학번으로 지정합니다.

        map.put(student1.getStuNum(), student1 );
        map.put(student2.getStuNum(), student2 );
        map.put(student3.getStuNum(), student3 );

        System.out.println(map.get(student2.getStuNum()).getStuName());

    }
}
