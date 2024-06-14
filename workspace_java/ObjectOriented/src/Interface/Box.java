package Interface;

//무엇이든 넣고 뺄 수 있는 만능 상자
public class Box {
    Object str;

    public void setBox(Object str){ //object는 모든 클래스가 들어가짐
        this.str = str;
    }

    public Object getBox(){
        return str;
    }


}


