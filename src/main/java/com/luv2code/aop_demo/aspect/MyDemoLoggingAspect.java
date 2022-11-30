package com.luv2code.aop_demo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advice for logging

    // let's start with an @Before advice

    @Before("execution(* com.luv2code.aop_demo.dao.*.*(..))")   // this is called point cut expression //
    // if you want to apply on a specific class ,you should give the full qualified name ,
    // if you want to apply on all the methods from all classes ,you just write the method name
    // if you want to apply with a return type , it will check only the methods that matches that
    // if you want to apply with matching many parameters ,you should add the first parameter ,and then .. for the rest of them

    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }

}
