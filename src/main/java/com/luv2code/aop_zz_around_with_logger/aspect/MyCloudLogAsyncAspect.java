package com.luv2code.aop_zz_around_with_logger.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.luv2code.aop_zz_around_with_logger.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void logToCloudAsync() {
        System.out.println("\n====>>> Logging to cloud in async fashion");
    }
}
