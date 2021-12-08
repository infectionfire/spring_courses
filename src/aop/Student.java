package aop;

public class Student {
    private String nameSurname;
    private int course;
    private double averageGrade;


    public Student(String nameSurname, int course, double averageGrade) {
        this.nameSurname = nameSurname;
        this.course = course;
        this.averageGrade = averageGrade;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public int getCourse() {
        return course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", course=" + course +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
