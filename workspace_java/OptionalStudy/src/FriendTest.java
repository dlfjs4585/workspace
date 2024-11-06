import java.util.Optional;

public class FriendTest {
    public static void main(String[] args) {
        ContactInfo contact = new ContactInfo("01012341234", "울산시");
        Company c = new Company("자바회사", contact);
        Friend f = new Friend("홍길동", c);
        originPrint(f);

        Optional<Friend> optional = Optional.ofNullable(f);
        optionalPrint(optional);
    }

    // 기존 방식 코드
    // 주소 출력
    public static void originPrint(Friend friend){
        String addr = null;
        if(friend != null){
            if (friend.getCompany() != null){
                if (friend.getCompany().getContactInfo() != null){
                    addr = friend.getCompany().getContactInfo().getAddr();
                }
            }
        }
        if(addr != null){
            System.out.println(addr);
        }
        else {
            System.out.println("주소가 존재하지 않습니다.");
        }
    }

    // Optional 사용 코드
    public static void optionalPrint(Optional<Friend> optional){
        // Function<T> -> R apply(T t)
        String addr = optional.map( friend -> friend.getCompany() )
                              .map( company -> company.getContactInfo() )
                              .map( contactInfo -> contactInfo.getAddr() )
                              .orElse("주소 정보가 없습니다.");
        System.out.println(addr);
    }

}
