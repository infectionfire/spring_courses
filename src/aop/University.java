package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudent(){
        Student st1 = new Student("ivanov Sergei", 6 , 5);
        Student st2 = new Student("Semenov Adndrey", 6, 4.5);
        Student st3 = new Student("ivanov Vanya", 6 ,5.5 );
        students.add(st1);
        students.add(st2);
        students.add(st3);


    }
    public List<Student> getStudents(){
        System.out.println("information from method getStudents");
//        System.out.println(students.get(3));
        System.out.println(students);
        return students;
    }
}
