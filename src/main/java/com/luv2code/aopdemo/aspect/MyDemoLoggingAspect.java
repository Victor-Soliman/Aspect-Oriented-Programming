package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advice for logging

    // let's start with an @Before advice

    @Before("execution(* add*(com.luv2code.aopdemo.Account))")   // this is called point cut expression //
    // if you want to apply on a specific class ,you should give the full qualified name ,
    // if you want to apply on all the methods from all classes ,you just write the method name
    // if you ant to apply with a return type , it will check only the methods that matches that

    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }

}
