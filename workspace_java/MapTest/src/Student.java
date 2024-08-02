public class Student {
    private int stuNum;
    private String stuName;


    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public Student(String stuName, int stuNum) {
        this.stuName = stuName;
        this.stuNum = stuNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuNum=" + stuNum +
                '}';
    }
}
