package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudent();
        //автотроуинг дает возможность что-то сделать перед тем, как исключение пройдет в мейн, но не можем
        //ничего сделать, он не обрабатывается
        //для обработки используем try catch finally (@after)
        try {
            List<Student> students = university.getStudents();
            System.out.println(students);
        }catch (Exception e) {
            System.out.println("Было поймано исключение: " + e);
        }

        context.close();
    }
}
