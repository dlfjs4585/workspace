package 상속;

public class Animal_2 {
    public static void main(String[] args) {

        Animal[] animalHouse = new Animal[10];
        Dog d1 = new Dog();
        Cat c1 = new Cat();
        Cow cow1 = new Cow();

        animalHouse[0] = d1;
        animalHouse[1] = c1;
        animalHouse[2] = cow1;

        //Animal클래스의 변수,메서드 사용가능
        //Dog클래스의 변수, 메서드 사용 불가능
        animalHouse[0].bark();

        for (int i =0; i < 3; i++){
            animalHouse[i].bark();
        }

    }
}
