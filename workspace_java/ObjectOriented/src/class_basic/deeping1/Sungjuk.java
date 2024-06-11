package class_basic.deeping1;

public class Sungjuk {
    int kor;
    int eng;
    int math;
    int[] scores;
    int sum;
    double avg;

    public Sungjuk(int kor, int eng, int math){
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.sum = kor+eng+math;
        this.avg = (double)sum / scores.length;
    }

    public void setSongjuk(int kor, int eng, int math){
        this.kor = kor;
        this.eng = eng;
        this.math = math;

    }
}
