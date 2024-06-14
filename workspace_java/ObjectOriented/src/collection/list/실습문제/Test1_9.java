package collection.list.실습문제;

import java.util.ArrayList;
import java.util.List;

public class Test1_9 {

}

class TestStudent{
    public static void main(String[] args) {

        List<Student> stu = new ArrayList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        student1.setStuName("kim");
        student1.setKorScore(80);
        student1.setEngScore(80);
        student1.setTotalScores(student1.getKorScore() + student1.getEngScore());

        student2.setStuName("lee");
        student2.setKorScore(70);
        student2.setEngScore(70);
        student2.setTotalScores(student2.getKorScore() + student2.getEngScore());

        student3.setStuName("park");
        student3.setKorScore(70);
        student3.setEngScore(80);
        student3.setTotalScores(student3.getKorScore() + student3.getEngScore());

        stu.add(student1);
        stu.add(student2);
        stu.add(student3);

        for (int i = 0; i < stu.size(); i++){
            System.out.println(stu.get(i));
        }

        System.out.println();

        for (int i = 0; i < stu.size(); i++){
            if (stu.get(i).totalScores >= 150){
                System.out.println(stu.get(i));
            }
        }

        System.out.println();

        for (int i = 0; i < stu.size(); i++){
            double avg = stu.get(i).totalScores/2;
            System.out.println(avg);
        }

        System.out.println();

        if (stu.get(0).totalScores > stu.get(1).totalScores){
            if (stu.get(0).totalScores > stu.get(2).totalScores){
                System.out.println(stu.get(0).totalScores);
            }
            else if(stu.get(0).totalScores < stu.get(2).totalScores){
                System.out.println(stu.get(2).totalScores);
            }
        }
        else if(stu.get(1).totalScores > stu.get(0).totalScores){
            if (stu.get(1).totalScores > stu.get(2).totalScores){
                System.out.println(stu.get(1).totalScores);
            }
            else if (stu.get(1).totalScores < stu.get(2).totalScores){
                System.out.println(stu.get(2).totalScores);
            }

        }
        else {
            System.out.println(stu.get(2).totalScores);
        }


    }
}

class Student{
    String stuName;
    int korScore;
    int engScore;
    int totalScores;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getTotalScores() {
        return totalScores;
    }

    public void setTotalScores(int totalScores) {
        this.totalScores = totalScores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", korScore=" + korScore +
                ", engScore=" + engScore +
                ", totalScores=" + totalScores +
                '}';
    }
}
