package 여섯_배열;

public class Test3_2 {
    public static void main(String[] args) {
        //정수 10개를 담을 수 있는 배열을 생성하고, Math.random()함수를
        // 사용하여 1 ~ 100의 정수를 배열 각 요소에 저장하자. 배열에 저장된
        // 모든 정수 및 최소값, 최대값을 출력해보라.
        // (Math.random() 메소드는 0 <= x < 1 사이의 실수를 리턴한다.)
        int[] arr = new int[10];
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100)+1;
            if (max < arr[i]){
                max = arr[i];
                System.out.println(max);
            }
            else if (min > arr[i]){
                min = arr[i];
                System.out.println(min);
            }
        }
    }
}
