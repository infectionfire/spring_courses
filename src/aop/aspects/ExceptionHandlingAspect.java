package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(30)
public class ExceptionHandlingAspect {
    @Before("aop.aspects.MyPointcuts.allAddMethod()")
    public void beforeAddExceptionHendlingAdvice(){
        System.out.println("beforeGetExceptionHendlingAdvice: ловим, обрабатываем" +
                "исключение при попытке получить книгу/журнал");
    }
}
