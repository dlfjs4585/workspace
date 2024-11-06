
// 회사정보
public class Company {
    private String companyName;
    private ContactInfo contactInfo;

    public Company(String companyName, ContactInfo contactInfo) {
        this.companyName = companyName;
        this.contactInfo = contactInfo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }
}
