package 여섯_배열;

public class 배열과기본자료형의차이 {
    public static void main(String[] args) {
//        int a = 10;
//        int b = a;
//        a = 20;
//        System.out.println("a =" + a);
//        System.out.println("b =" + b);

        int[] a = {1 ,3 ,5};
        int[] b = a;
        a[0] = 10;
        b[2] = 50;


        for (int e : a){
            System.out.print(e + " ");
        }
        System.out.println();
        for (int e : b){
            System.out.print(e + " ");

        }

        //배열의 복사
        int[] c = {1,2,3};
        int[] d = c.clone();

    }
}
