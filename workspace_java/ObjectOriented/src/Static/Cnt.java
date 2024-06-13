package Static;

public class Cnt {
    //static : 맴버변수, 메서드에서 사용가능
    //공용변수, 공용메서드를 의미한다.

    static int num = 0;

    public Cnt(){
        num++;
        System.out.println(num);
    }


}
