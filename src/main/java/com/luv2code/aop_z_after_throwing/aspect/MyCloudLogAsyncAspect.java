package com.luv2code.aop_z_after_throwing.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.luv2code.aop_z_after_throwing.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void logToCloudAsync() {
        System.out.println("\n====>>> Logging to cloud in async fashion");
    }
}
