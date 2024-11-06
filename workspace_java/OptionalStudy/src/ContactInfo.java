
// 연락정보
public class ContactInfo {
    private String phone; // null 들어갈 수 있음
    private String addr; // null 들어갈 수 있음

    public ContactInfo (String phone, String addr){
        this.phone = phone;
        this.addr = addr;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddr(){
        return addr;
    }


}
