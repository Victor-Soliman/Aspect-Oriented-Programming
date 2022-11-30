package com.luv2code.aop_pointcut_order_aspects.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
        // here you should put the fully qualified name of LuvAopExpressions before the name of the method ,because
        // it has the declaration of the pointcuts
    @Before("com.luv2code.aop_pointcut_order_aspects.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }


}
