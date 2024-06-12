package 상속;

//우리 병원에는 강아치, 고양이, 송아지 3종류의 동물 관리
//병원에는 총 10개의 케이지가 존재한다.
//단, 3종류의 동물 수는 항상 변화한다.


class Animal{
    public void bark(){
        System.out.println("동물들이 웁니다~");
    }
}

public class Dog extends Animal{
    public void bark(){
        System.out.println("뭥뭥");
    }
}

class Cat extends Animal{
    public void bark(){
        System.out.println("야옹");
    }
}

class Cow extends Animal{
    public void bark(){
        System.out.println("음머");
    }
}


