package class_basic.man;

public class Man {

    private String name;
    private int age;
    private String addr;

    public Man(String name, int age, String addr){
        this.name = name;
        this.age = age;
        this.addr = addr;
    }
    //setter : 맴버변수 각각의 값을 변경하는 메서드
    //setter의 이름은 set변수명 으로 반드시 지정!
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setAddr(String addr){
        this.addr = addr;
    }
    //getter : 맴버변수 각각의 값을 return받는 메서드
    //getter의 이름은 반드시 get변수명 으로 반드시 지정!
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddr(){
        return addr;
    }


    public void printManInfo(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + addr);
    }


}
