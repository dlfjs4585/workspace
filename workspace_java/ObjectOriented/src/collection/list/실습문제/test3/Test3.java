package collection.list.실습문제.test3;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        //자바반에 소속될 학생 3명 생성
        Student stu1 = new Student("lee",17,80);
        Student stu2 = new Student("kim",17,85);
        Student stu3 = new Student("park",17,90);
        Student stu4 = new Student("lee",18,80);
        Student stu5 = new Student("kim",18,85);
        Student stu6 = new Student("park",18,90);
        Student stu7 = new Student("lee",19,80);
        Student stu8 = new Student("kim",19,85);
        Student stu9 = new Student("park",19,90);

        //자바반에 저장할 학생 list 생성
        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(stu1);
        studentList1.add(stu2);
        studentList1.add(stu3);
        //캐드반에 저장할 학생 list 생성
        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(stu4);
        studentList2.add(stu5);
        studentList2.add(stu6);
        //파이썬반에 저장할 학생 list 생성
        List<Student> studentList3 = new ArrayList<>();
        studentList3.add(stu7);
        studentList3.add(stu8);
        studentList3.add(stu9);


        //자바반 생성
        StudyClass javaClass = new StudyClass("자바반","강사_자바", studentList1);
        //캐드반 생성
        StudyClass cadClass = new StudyClass("캐드반","강사_캐드", studentList2);
        //파이썬반 생성
        StudyClass pythonClass = new StudyClass("파이썬반","강사_파이썬", studentList3);

        List<StudyClass> studyClassList = new ArrayList<>();
        studyClassList.add(javaClass);
        studyClassList.add(cadClass);
        studyClassList.add(pythonClass);


        School school = new School(studyClassList);

        //학교안의 모든 학생들의 정보를 출력
        for (int i = 0; i < studyClassList.size(); i++){
            for (int j = 0; j < school.getStudyClassList().get(i).getStudentList().size(); j++){
                System.out.println(school.getStudyClassList().get(i).getStudentList());
            }
        }

    }
}

class Student{
    private String stuName;
    private int age;
    private int score;

    public Student(String stuName, int age, int score) {
        this.stuName = stuName;
        this.age = age;
        this.score = score;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

class StudyClass{
    private List<Student> studentList;
    private String className;
    private String teacherName;

    public StudyClass(String className, String teacherName, List<Student> studentList){
        this.className = className;
        this.teacherName = teacherName;
        this.studentList = studentList;
    }

    //해당 반의 모든 학생의 모든 정보를 출력하는 기능
    public void printStudentListAll(){
        for ( Student  stu : studentList){
            System.out.println(studentList);
        }
    }

    public List<Student> getStudentList(){
        return studentList;
    }

    public double avg(){
        int sum = 0;
        int cnt = 0;
        double avg = sum / (double)cnt;
        for (int i = 0; i < studentList.size(); i++){
            sum = sum + studentList.get(i).getScore();
            cnt++;
        }
        return avg;
    }

    public int highScore(){
        int max = 0;
        for (int i = 0; i < studentList.size(); i++){
            if (max < studentList.get(i).getScore()){
                max = studentList.get(i).getScore();
            }
        }
        return max;
    }
}

class School{
    private List<StudyClass> studyClassList;

    public School(List<StudyClass> studyClassList){
        this.studyClassList = studyClassList;
    }

    public List<StudyClass> getStudyClassList(){
        return studyClassList;
    }



}
