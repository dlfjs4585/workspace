package Static;

//예금 이율 : 7%
public class Account {
    String accNum; //계좌번호
    int money; //예금액
    double iyul; //이율

    public Account(String accNum,int money){
        this.accNum = accNum;
        this.money = money;
        iyul = 7.0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNum='" + accNum + '\'' +
                ", money=" + money +
                ", iyul=" + iyul +
                '}';
    }
}
