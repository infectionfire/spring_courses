package aop.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public class NewLoggingAspect {

//можно обработать исключение внутри эдвайса и тест 3 не знает о его существовании, лучше пробрасывать дальше
        @Around("execution(public String returnBook())")
        public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

            //выполняем свою логику до начала метода
            System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть "+
                    "книгу");
            //вызываем и логгируем метод после работы
            Object targetMethodResult = null;
            try {
                targetMethodResult = proceedingJoinPoint.proceed();
            } catch (Exception e){
                System.out.println("Было залогировано исключение: "+ e);
                throw e;
            }
            //можно поменять ответ самостоятельно

            System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно возвращают "+
                    "книгу");

            //возвращаем результат

            return targetMethodResult;
    }
}
