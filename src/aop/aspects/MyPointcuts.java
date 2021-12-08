package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* abc*())")
    //можно сделать пабликом и использовать везде
    public void allAddMethod(){}


}
