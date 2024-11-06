public class Friend {
    private String name;
    private Company company;

    public Friend(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    // 친구가 다니는 회사의 주소 정보를 출력하는 메서드
    public void printCompanyAddress(){
        String addr = null;

        Company company1 = getCompany();
        if(company1 != null){
            ContactInfo contactInfo = company1.getContactInfo();
            if(contactInfo != null){
                addr = contactInfo.getAddr();
            }
        }

        if(addr != null){
            System.out.println(addr);
        }
        else {
            System.out.println("주소 정보가 없습니다.");
        }
    }






}
