package aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(20)
public class SecurityAspect {

    @Before("aop.aspects.MyPointcuts.allAddMethod()")
    public void beforeAddSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice осуществляется проверка прав на получение книги");
        System.out.println("<------------------------------------------->");
    }


}
