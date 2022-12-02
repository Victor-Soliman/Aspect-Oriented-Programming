package com.luv2code.aop_zzz_around_handle_exception.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.luv2code.aop_zzz_around_handle_exception.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics() {
        System.out.println("\n====>>> Performing API analytics");
    }
}
