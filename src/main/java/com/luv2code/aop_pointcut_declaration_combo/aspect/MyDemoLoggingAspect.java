package com.luv2code.aop_pointcut_declaration_combo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advice for logging

    // let's start with an @Before advice

    // 1.declaring a pointcut declaration
    @Pointcut("execution(* com.luv2code.aop_pointcut_declaration_combo.dao.*.*(..))")
    private void forDaoPackage() {

    }

    // create a pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aop_pointcut_declaration_combo.dao.*.get*(..))")
    private void forGetterMethods(){

    }
    // create a pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aop_pointcut_declaration_combo.dao.*.set*(..))")
    private void forSetterMethods(){

    }
    // create pointcut :include package ... exclude getter and setter
    @Pointcut("forDaoPackage() && !(forGetterMethods() || forSetterMethods())")
    public void forDaoPackageNoGetterNoSetter(){

    }

    // 2.reuse it(te pointcut declaration) in advice
    @Before("forDaoPackageNoGetterNoSetter()")   // this is called point cut expression //
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics() {
        System.out.println("\n====>>> Performing API analytics");
    }



}
