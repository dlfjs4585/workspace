package Interface.student;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        MyStudent myStudent = new MyStudent();

        Student[] students = new Student[5];

        Student student = new Student("kim",70,80,90);
        Student student1 = new Student("sin",65,70,60);
        Student student2 = new Student("jung",75,90,70);
        Student student3 = new Student("park",80,60,80);
        Student student4 = new Student("lee",90,50,90);
        students[0] = student;
        students[1] = student1;
        students[2] = student2;
        students[3] = student3;
        students[4] = student4;
        String result = myStudent.getGradeByStudentName(students,"sin");
        System.out.println(result);

        System.out.println();


        int[] result2 = myStudent.getTotalScoresToArray(students);
        System.out.println(Arrays.toString(result2));

        System.out.println();

        Student stu = myStudent.getHighScoreStudent(student1,student2);
        System.out.println(stu.getName());

    }
}
