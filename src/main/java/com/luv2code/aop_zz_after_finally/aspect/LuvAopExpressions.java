package com.luv2code.aop_zz_after_finally.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    // this is a utility class that is ganna hold the pointcuts expressions that we ganna access anywhere in our
    // application
    // we refactor the classes by moving them each on in a class , and we created this class to hold code we will use

    // we change the access modifiers to public so they can be accessed

    @Pointcut("execution(* com.luv2code.aop_z_after_returning.dao.*.*(..))")
    public void forDaoPackage() {

    }

    // create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aop_z_after_returning.*.get*(..))")
    public void forGetterMethods() {

    }

    // create pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aop_z_after_returning.*.set*(..))")
    public void forSetterMethods() {

    }

    // create pointcut :include package ... exclude getter and setter
    @Pointcut("forDaoPackage() && !(forGetterMethods() || forSetterMethods())")
    public void forDaoPackageNoGetterNoSetter() {

    }
}
