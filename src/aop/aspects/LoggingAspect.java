package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//в аспекте обычно содержится несколько эдвайсов
@Order(10)
public class LoggingAspect {


//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUnilibrary(){
//
//    }
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine(..))")
//    private void returnMagasineFromUnilibrary(){
//
//    }
//
////иключаем второй метод
//    @Pointcut("allMethodsFromUnilibrary() && !returnMagasineFromUnilibrary()")
//    private void allMethodExceptMethodFromUniLibrary(){
//
//    }
//
//    @Before("allMethodExceptMethodFromUniLibrary()")
//    public void beforeAllMethodExceptReturnMagazineAdvice(){
//        System.out.println("beforeAllMethodExceptReturnMagazineAdvice: log #10");
//    }


    @Before("aop.aspects.MyPointcuts.allAddMethod()")//написание в скобках называется point cut
    public void beforeAddLogingAdvice(JoinPoint joinPoint){



        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = "+ methodSignature);
        System.out.println("methodSignature.getMethod() = "+ methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = "+ methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = "+ methodSignature.getName());

        if (methodSignature.getName().equals("addBook")){
            Object[] args = joinPoint.getArgs();
            for (Object obj:args){
                    if (obj instanceof Book) {
                        Book myBook = (Book) obj;
                        System.out.println("Информация о книге: название - " + myBook.getName() + ", автор - "
                                + myBook.getAuthor()+ ", год издания - " + myBook.getYearOfPublication() );
                }else if (obj instanceof String){
                        System.out.println("книгу добавляет " + obj);
                    }
            }
        }

        System.out.println("beforeGetBookAdvice: попытка логгирования"+" попытка получить книгу/журнал");
        System.out.println("<------------------------------------------->");






    }

@Pointcut("execution(* aop.UniLibrary.get*())")
private void allGetMetdodFromUnilibrary() {
}

//    @Before("allGetMetdodFromUnilibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: лог номер 1");
//    }



    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void allReturnMetdodFromUnilibrary() {
    }


//    @Pointcut(" allGetMetdodFromUnilibrary() || allReturnMetdodFromUnilibrary()")
//    private void allGetReturnMethodOnUnilibrary(){
//
//    }
//
//
//
//    @Before("allReturnMetdodFromUnilibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: лог номер 2");
//    }
//
//
//    @Before("allGetReturnMethodOnUnilibrary()")
//    public void beforeGetReturnLoggingAdvice() {
//        System.out.println("beforeGetReturnLoggingAdvice: лог номер 3");
//    }


//
//    //advice- метод внутри аспект класса
//    //методы: @Before -до, @AfterReturning , после возврата @AfterThrowing , после выброса исключения
//    //@After/AfterFinally - в конце, @Around - до и после метода с основной логикой
//
//    //перед выполнением метода ниже выполняем этот метод
//    //можно сделать wildcard public void get*(), будет совпадать со всем, имеющим этот префикс и паблик войд
////
////
//    // .. = любое количество параметров, *-1

//обязательных параметра два: ретерн метод - в данном случае * и аксесс модифаер- ретурнбук
    @Before("execution( * returnBook())")//написание в скобках называется point cut
//    //можно указать для всех методов без параметров через * *()
    public void beforeReturnBookAdvice(){



        System.out.println("beforeReturnBookAdvice: попытка"+" вернуть книгу");

    }
//
//
////второй адвайс

}

