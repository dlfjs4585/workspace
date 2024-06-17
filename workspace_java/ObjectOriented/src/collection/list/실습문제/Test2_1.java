package collection.list.실습문제;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2_1 {
    public static void main(String[] args) {

<<<<<<< Updated upstream
        EmpService empService = new EmpService();

        //empService.login();
        System.out.println();
        //empService.printDeptMoney();
        System.out.println();
        empService.increaseMoney();

    }
=======
    }

>>>>>>> Stashed changes


class EmpService{
    private List<worker> work;
    private Scanner sc;


    public EmpService(){
        sc = new Scanner(System.in);
        work = new ArrayList<>();
        worker w1 = new worker(1001,"홍길동","개발부","1111-1234",1000);
        worker w2 = new worker(1002,"김길동","개발부","1111-1235",2000);
        worker w3 = new worker(1003,"최길동","개발부","1111-1236",3000);

        work.add(w1);
        work.add(w2);
        work.add(w3);
    }


    public void login(){
        boolean isRunning = true; // while문 반복 변수
        boolean isFind = false; // 사번 혹은 비밀번호를 반복문에서 빼서 실행 시키기 위한것
        //사번 : 1001
        //비밀번호(연락처의 마지막 4자리) : 1111
        //사번 혹은 비밀번호가 일치하지 않습니다.
        //사번 : 1001
        //비밀번호(연락처의 마지막 4자리) : 1234
        //로그인 하였습니다.
        //‘홍길동’님 반갑습니다.
        while (isRunning){
            System.out.print("사번 : ");
            int workNum = sc.nextInt();
            System.out.print("비밀번호(연락처의 마지막 4자리) : ");
            String pw = sc.next();

            //입력한 사번과 비밀번호 일치 여부 확인
            for ( worker e : work){
                if (e.getWorkerNum() == workNum && e.getPhoneNum().equals(pw)){
                    isRunning = false; // while문 벗어남
                    System.out.println("로그인 하였습니다.");
                    System.out.println("'" + e.getName() + "'" + "님 반갑습니다.");
                    isFind = true;
                }
            }
            if (!isFind){ // '!' : 부정연산자
                System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
            }

        }
//        for (int i = 0; i < work.size(); i++ ){
//            if (work.get(i).workerNum == workerNum){
//                if (work.get(i).phoneNum.equals(phoneNum)){
//                    System.out.println("로그인 하였습니다.");
//                    System.out.println(work.get(i).getName());
//                }
//                else {
//                    System.out.println("사번 혹은 비밀번호가 일치 하지 않습니다.");
//                }
//            }
//        }



    }
    // 2번
    public void printDeptMoney(){
        int sum = 0;
        int cnt = 0;
        System.out.print("부서명 : ");
        String dept = sc.next();
        System.out.println("==" + dept + "월급 현황==");
        for (int i = 0; i < work.size(); i++){
            if (work.get(i).getDepName().equals(dept)){
                System.out.println("이름 : " + work.get(i).getName() + " 월급 : " + work.get(i).getMoney());
                sum = sum + work.get(i).getMoney();
                cnt++;
            }
        }
        System.out.println(dept + "의 월급 총액은 " + sum + "원이며, 평균 급여는 " + sum / (double)cnt + "원입니다.");
    }

    // 3번
    public void increaseMoney(){
        System.out.print("부서명 : ");
        String dept = sc.next();
        System.out.print("인상급여 : ");
        int money = sc.nextInt();

        System.out.println(dept + " 각 사원의 급여가 각각 " + money + "원씩 인상됩니다.");
        System.out.println("==월급 인상 후 " + dept + "월급 현황==");

        //급연인상을 위한 코드
        for (worker worker : work ){
            if (worker.getDepName().equals(dept)){
                worker.setMoney(worker.getMoney() + money);
            }
        }
        for (worker worker : work ){
            if (worker.getDepName().equals(dept)){
                System.out.println(worker);
            }
        }

    }
}

class worker{
    int workerNum;
    String name;
    String depName;
    String phoneNum;
    int money;

    //사원의 연락처 마지막 4자리값 리턴
    public String getPw(){
//        String num = "010-1111-2222";
//        num.substring(1,4);//1번째부터 4번째 전까지"10-"
//        num.substring(5);//5번째부터 끝까지"111-2222"
        return phoneNum.substring(5);
    }

    public worker(int workerNum, String name, String depName, String phoneNum, int money) {
        this.workerNum = workerNum;
        this.name = name;
        this.depName = depName;
        this.phoneNum = phoneNum;
        this.money = money;
    }

    public int getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(int workerNum) {
        this.workerNum = workerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "worker{" +
                "workerNum=" + workerNum +
                ", name='" + name + '\'' +
                ", depName='" + depName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
