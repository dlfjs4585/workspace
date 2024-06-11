package class_basic.man;

//배열 + 클래스
public class StuTest {
    public static void main(String[] args) {

        //학생을 5명 저장할 수 있는 배열 생성
        //학생 5명을 저장할 수 있는 공간을 생성한것.(현재 학생이 저장 되어있지 않다.)
        Student[] students = new Student[5];//배열에는 현재 null이 들어가있음

        //배열에 저장할 학생 객체 생성
        Student st1 = new Student("kim",20,90);
        Student st2 = new Student("lee",20,85);
        Student st3 = new Student("na",20,95);
        Student st4 = new Student("park",20,80);
        Student st5 = new Student("kim",20,75);

        students[0] = st1;
        students[1] = st2;
        students[2] = st3;
        students[3] = st4;
        students[4] = st5;

        //1. 배열에 저장된 모든 학생의 이름,나이,점수를 출력
//        for (int i =0; i < students.length; i++){
//            students[i].stuInfo();
//            System.out.println();
//        }

        //1번 문제를 for-each문으로 해결
//        for( Student s : students){
//            s.stuInfo();
//            System.out.println();
//        }

        //2. 배열에 저장도니 학생 중 점수가 80점 이상인 학생의 이름, 나이, 점수 출력
//        for (int i = 0; i < students.length; i++){
//            if (students[i].getScore() >= 80){
//                students[i].stuInfo();
//            }
//        }

        //3. 이름이 '박'인 학생을 찾아 해당 학생의 나이를 10으로 변경
        //for, for-each

        for (int i = 0; i < students.length; i++){
            if (students[i].getName().equals("park")){
                students[i].setAge(10);

            }
        }
        for (Student s : students){
            if (s.getName().equals("park")){
                s.setAge(10);
            }
        }


    }
}
