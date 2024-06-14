package Interface.student;


public class MyStudent implements StudentUtil{



    @Override
    public String getGradeByStudentName(Student[] students, String name) {
        String grade = "등급없음"; //초기값 등급없음
        for ( Student stu : students ){
            if (stu.getName().equals(name)){
                double avg = (stu.getKorScore() + stu.getEngScore() + stu.getMathScore()) / 3.0;
                grade = getGradeByAvg(avg);
            }
        }
        return grade;
    }
    //점수에 따라 등급을 결정하는 메서드
    private String getGradeByAvg(double avg){
        String grade ="등급없음";
        if (avg >= 90 && avg <= 100){
            grade = "A";
        }
        else if(avg >= 80){
            grade = "B";
        }
        else if(avg >= 70){
            grade = "C";
        }
        else {
            grade = "D";
        }
        return grade;
    }

    @Override
    public int[] getTotalScoresToArray(Student[] students) {
        //학생들의 총점이 저장될 배열 생성
        int[] totalScores = new int[students.length];
        for (int i = 0; i < students.length; i++){
            totalScores[i] = students[i].getKorScore() + students[i].getEngScore() + students[i].getMathScore();
        }
        return totalScores;
    }

    @Override
    public Student getHighScoreStudent(Student stu1, Student stu2) {
        int totalScore1 = stu1.getKorScore() + stu1.getEngScore() + stu1.getMathScore();
        int totalScore2 = stu2.getKorScore() + stu2.getEngScore() + stu2.getMathScore();
        return totalScore1 > totalScore2 ? stu1 : stu2;
    }
}
