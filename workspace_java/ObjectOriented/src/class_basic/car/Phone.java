package class_basic.car;

//접근제한자 : 클래스, 메서드, 맴버변수에서 사용
//1. public : 프로젝트 내에 존재하면 접근 가능
//2. default : 같은 패키지 내에 있으면 접근 가능(아무것도 적혀있지 않는게 default)
//3. protected : 패스
//4. private : 변수, 메서드가 선원된 클래스 안에서만 접근 가능

//맴버변수에는 무조건 private
//메서드는 무조건 public
public class Phone {
    private int price;
    public String modelName;
    String brand;


    //생성자
    public Phone(){
        this.price = 0;
        this.modelName = "";
    }
    public void setPrice(int price){
        this.price = price;
    }


}

