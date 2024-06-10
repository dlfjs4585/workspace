package class_basic;

public class AccountTest {
    public static void main(String[] args) {
                        //생성자 호출하는것 매우중요
        Account a1 = new Account();
        a1.printAccount();

        Account a2 = new Account(100000);
        a2.printAccount();

    }
}
