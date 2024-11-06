public class LocalOuter {
    private String content;

    public LocalOuter(String content){
        this.content = content;
    }

    public Printable getPrint (){

        // Printable 인터페이스의 객체 생성
        // 1. 인터페이스만으로는 객체생성 불가 -> 인터페이스를 구현한 클래스 생성
        // 2. 해당 클래스에 대한 객체 생성
        //MyPrint myPrint = new MyPrint();

        // Printable 인터페이스를 구현한 클래스
        // inner class 로 넣어주는 이유는 안정성을 위해서이다.
        // ------------------- local inner class ---------------------
        class MyPrint implements Printable{

            @Override
            public void print() {
                System.out.println("프린터 실행@@@@@@@@@@@@@@");
            }
        }

        Printable p = new MyPrint();
        // ------------------- local inner class end ---------------------

        // ------------------- local inner class -> anonymous inner class 변환 ---------------------

        Printable p1 = new Printable() {
            public void print() {
                System.out.println(1111);
            }
        };

        // ------------------- local inner class -> anonymous inner class 변환 end ---------------------

        // ----- anonymous -> 람다로의 변환 -------- //

        Printable p2 = () -> {System.out.println(1111);};

        // ----- anonymous -> 람다로의 변환 end -------- //

        // 생성한 객체를 리턴
        return p;
    }





















}