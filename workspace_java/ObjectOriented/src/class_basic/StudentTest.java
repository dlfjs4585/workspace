package class_basic;

public class StudentTest {
    public static void main(String[] args) {

        Student stu1 = new Student();
        System.out.println(stu1.name);
        stu1.age = 19;
        stu1.introduce();
        stu1.setName("kim");
        stu1.introduce();
        stu1.setAge(25);
        stu1.introduce();
    }




}
