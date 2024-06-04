package 여섯_배열;

public class 배열_3 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];//0 0 0 0 0
        System.out.println(arr1);//이상한 값 나옴.

        //배열에 저장된 값을 출력할 때는 배열의 욧로 접근한다.
        System.out.println(arr1[0]);

        //arr1의 0~4번째 요소까지의 모든 값을 출력

        for (int i =0; i < arr1.length ; i++ ){
            System.out.println(arr1[i]);
        }

        System.out.println();

        //배열의 크기
        int[] arr2 = new int[2];
        int[] arr3 = new int[5];
        int[] arr4 = new int[10];


        //배열명.length 를 사용하면 배열의 크기를 알 수 있음!
        System.out.println(arr2.length);
    }
}














