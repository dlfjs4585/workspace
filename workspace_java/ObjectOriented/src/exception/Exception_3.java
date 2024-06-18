package exception;

//예외전가
public class Exception_3 {
    public static void main(String[] args) {
        try {
            bbb();
        }catch (Exception e){

        }
    }
    //throws Exception 오류가 일어난 부분을 다음단계에서 처리하게한다.
    public static void aaa() throws Exception {
        System.out.println(5/0);
    }

    public static void bbb() throws Exception {
        aaa();
    }
}
