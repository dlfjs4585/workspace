package collection.list.실습문제;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2_1 { }

class EmpService{

    List<worker> work = new ArrayList<>();
    worker work1 = new worker();
    worker work2 = new worker();
    worker work3 = new worker();



    public void login(int workerNum,String phoneNum){
        //사번 : 1001
        //비밀번호(연락처의 마지막 4자리) : 1111
        //사번 혹은 비밀번호가 일치하지 않습니다.
        //사번 : 1001
        //비밀번호(연락처의 마지막 4자리) : 1234
        //로그인 하였습니다.
        //‘홍길동’님 반갑습니다.
        for (int i = 0; i < work.size(); i++ ){
            if (work.get(i).workerNum == workerNum){
                if (work.get(i).phoneNum.equals(phoneNum)){
                    System.out.println("로그인 하였습니다.");
                    System.out.println(work.get(i).getName());
                }
                else {
                    System.out.println("사번 혹은 비밀번호가 일치 하지 않습니다.");
                }
            }
            else {
                System.out.println("사번 혹은 비밀번호가 일치 하지 않습니다.");
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
