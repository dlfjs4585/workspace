package basic;


// 클래스가 Generic 이 아닌! 클래스 안의 특정 메서드만 Generic 화 시키기
public class GenericMethod {

    /*
       매개변수로 data 가 전달됨
       그 데이터는 자료형이 정해지지 않음
       이러한 매개변수를 전달받아, 박스에 저장하고
       데이터가 저장된 박스를 리턴하는 메서드
    */
    public static <T> Box<T> makeBox(T data) {
        Box<T> box = new Box<>();
        box.setData(data);
        return box;
    }

    // 매개변수로 Box<String> 객체전달 가능
    public static <T>void peekBox(Box<T> box){
        System.out.println(box);
    }

    // Generic 메서드가 아니다.
    // 와일드 카드 문법 - 위의 peekBox 메서드와 완전 동일
    // Generic 문법으로는 클래스를 만드는걸 권장
    // 와일드 카드 문법으로는 메서드를 만드는걸 권장
    public static void peekBox1(Box<?> box){
        System.out.println(box);
    }

    // 와일드 카드의 상한제한, 하한제한 문법(Generic 문법의 타입인자 제한과 비슷)
    // 와일드 카드의 상한제한
    // ?에 들어오는 자료형을 제한
    // Phone 클래스, 혹은 Phone 클래스를 상속한 클래스만 들어 올 수 있음
    // Box<Phone> 이렇게 해석하면됨
    public static void peekBox3(Box<? extends Phone> box){
        //box.getData().call();
        System.out.println(box);
    }

    // 와일드 카드의 하한제한
    // Phone 클래스이거나 Phone 클래스의 상위 클래스만 들어올 수 있음
    // Box<MobilePhone> 이렇게 해석하면됨
    public static void peekBox4(Box<? super MobilePhone> box){

        System.out.println(box);
    }

    // 상한제한 사용 이유
    // outBox 에서는 매개변수로 전달된 장난감이 들어있는 박스에서
    // 장난감을 꺼내는 기능
    // 상한제한을 걸어주는 이유는 데이터를 저장하는 기능을 제한하기 위해서이다.(코드의 안정성 높임)
    public static void outBox(Box<? extends Toy> box){
        Toy toy = box.getData();
        // box.setData(new Toy()); Toy 안에 Box<Car>, Box<Robot> 이 들어왔을 때 안됨.
    }

    // 상한, 하한제한 사용의 적절한 예시
    // 매개변수로 두 개의 상자가 전달되고
    // 하나의 상자의 데이터를 다른 하나의 상자에 옮기는 기능
    public static void moveBox(Box<? super Toy> toyBox,  Box<? extends Toy> fromBox){
        // fromBox -> toBox
        Toy t = fromBox.getData();
        toyBox.setData(t);
    }

    // 와일드 카드의 최초 목적 : 여러 자료형을 전달받기 위해서
    // 코드의 안정성 향상을 위해 상한, 하한 제한 도입 : 최초 목적을 상실
    // 이 문제를 해결하기 위해 Generic, 와일드 카드를 동시에 사용!
    public <T> void finalOutBox(Box<? extends T> box){
        
    }

    // 매개변수로 박스와, 박스에 담을 객체 전달
    // 전달받은 박스에 전달받은 객체를 저장
    // 하한제한을 걸어주는 이유는 데이터를 조회하는 기능을 제한하기 위해서이다.
    public static void inBox(Box<? super Toy> box, Toy toy){
        box.setData(toy);           // Box<Object>, Box<Toy>
        // Toy t = box.getData();  Object 가 들어오게 되면 리턴타입이 달라짐
    }


    // 매개변수로 Box<String> 객체 전달 불가능
    // 이 메서드는 object 가 들어간 박스만 전달 가능한거지 object 아님.
    public static void peekBox2(Box<Object> box){
        System.out.println(box);
    }









}
