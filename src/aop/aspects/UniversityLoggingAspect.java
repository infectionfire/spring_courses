package aop.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class UniversityLoggingAspect {


//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice(){
//        System.out.println("beforeGetStudentsLoggingAdvice: логгируем получение списка студентов перед методом "
//        + "getStudents");
//    }
//срабатывает после таргет метода, может перехватывать результат и делать определенную работу
//    @AfterReturning(pointcut = "execution(* getStudents())",
//    returning = "students")
//    //имя должно совпадать с ретернингом
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
//
//        //просто так результат таргет метода не меняется, только в исключительных
//        Student firstStudent = students.get(0);
//        String nameSurname =  firstStudent.getNameSurname();
//        nameSurname = "Mr. "+nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//
//
//        double avgGrade = firstStudent.getAverageGrade();
//        avgGrade = avgGrade+1;
//        firstStudent.setAverageGrade(avgGrade);
//
//
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логгируем получение списка студентов после "
//                + "работы метода getStudents");
//    }

//    @AfterThrowing(pointcut = "execution(* getStudents())",
//    throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
//        //
//        System.out.println("afterThrowingGetStudentsLoggingAdvice Логгируем выброс исключения: " + exception);
//    }




    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: логгируем нормальное окончание работы метода или выброс" +
                "исключения");
    }
}
