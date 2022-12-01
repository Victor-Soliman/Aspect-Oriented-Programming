package com.luv2code.aop_z_after_returning.aspect;


import com.luv2code.aop_read_joinPoint.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @ AfterReturning on the findAccounts method

    // takes 2 parameters : JoinPoint and in our case List of Account
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aop_z_after_returning.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("====> Executing @AfterReturning on method : " + method);

        // print out the results of the method call
        System.out.println("====> result is  : " + result);

        // -----

        // modify "result" list : add, remove  , update ,etc
        // let's post-process the data ... let's modify it :)

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("====> result is  : " + result);


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
    @Before("com.luv2code.aop_z_after_returning.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method : " + methodSig);

        // display method args , and loop thru args
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }
}

