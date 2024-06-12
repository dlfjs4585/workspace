package 상속.실습문제;

public class Work {
    public static void main(String[] args) {
        B bp = new B();
        B bp1 = new B(10);
        B bp2 = new B(10,20);
        //B bp3 = new B(10,20,30);
        //B bp4 = new B(10,20,30,40);

        bp.disp(); // x=1,y=1,x=1,y=1
        bp1.disp(); // x=10,y=1,x=1,y=1
        bp2.disp(); // x=10,y=20,x=1,y=1
        //bp3.disp(); // x=10,y=20,x=30,y=1
        //bp4.disp(); // x=10,y=20,x=30,y=40

    }
}

class A{
    private int x;
    private int y;

    public A(){
        this.x = 1;
        this.y = 1;
    }

    public A(int x){
        this.x = x;
        y = 1;
    }

    public A(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void disp(){
        System.out.print("x = " + x + "," + "y = " + y);
    }
}

class B extends A{
    private int x;
    private int y;

    public B(){
        x = 1;
        y = 1;
    }

    public B(int x){
        super(x);
        this.x =1;
        y =1;
    }

    public B(int x, int y){
        super(x,y);
        this.x =1;
        this.y =1;
    }

    public void disp(){
        super.disp();
        System.out.println(",x = " + x + "," + "y = " + y);
    }


}

