package com.luv2code.aop_zzz_around_handle_exception.aspect;


import com.luv2code.aop_read_joinPoint.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.luv2code.aop_zzz_around_handle_exception.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now , let's execute the method
        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
            //  theProceedingJoinPoint : will handle to target method // .proceed() : to execute the target method

        } catch (Exception e) {
            // log the exception
            myLogger.warning(e.getMessage());

            // give user a custom message
//            result = "Major accident! But no worries, your private AOP helicopter is on the way!";

            // rethrow exception
            throw  e ;
        }


        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.luv2code.aop_zzz_around_handle_exception.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n====> Executing @After (finally) on method : " + method);

    }


    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aop_zzz_around_handle_exception.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {
        // print out witch method we are advicing on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("====> Executing @AfterThrowing on method : " + method);

        // log the exception
        myLogger.info("====> The exception is  : " + theExc);

    }

    // ---

    // add a new advice for @ AfterReturning on the findAccounts method

    // takes 2 parameters : JoinPoint and in our case List of Account
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aop_zzz_around_handle_exception.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("====> Executing @AfterReturning on method : " + method);

        // print out the results of the method call
        myLogger.info("====> result is  : " + result);

        // -----

        // modify "result" list : add, remove  , update ,etc
        // let's post-process the data ... let's modify it :)

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        myLogger.info("====> result is  : " + result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount : result) {
            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();
            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    // here you should put the fully qualified name of LuvAopExpressions before the name of the method ,because
    // it has the declaration of the pointcuts
    @Before("com.luv2code.aop_zzz_around_handle_exception.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method : " + methodSig);

        // display method args , and loop thru args
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            myLogger.info(tempArg.toString());

            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                myLogger.info("Account name: " + theAccount.getName());
                myLogger.info("Account level: " + theAccount.getLevel());
            }
        }
    }
}

