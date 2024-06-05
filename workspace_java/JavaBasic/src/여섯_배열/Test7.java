package 여섯_배열;

public class Test7 {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,9,10,11,12};
//        int cnt = 0;
//        for (int i = 0; i < arr1.length; i++){
//            if (arr1[i] % 2 == 0){
//                cnt++;
//            }
//        }
//        System.out.println(cnt);

        //for each문
        int cnt = 0;
        for (int e : arr1){
            if (e % 2 == 0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
