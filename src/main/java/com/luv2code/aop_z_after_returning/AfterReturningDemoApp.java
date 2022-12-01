package com.luv2code.aop_z_after_returning;

import com.luv2code.aop_z_after_returning.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class AfterReturningDemoApp {
    public static void main(String[] args) {
        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\nMain Program: After ReturningDemoApp");
        System.out.println("-----");

        System.out.println(theAccounts);
        System.out.println("\n");


        context.close();

    }
}
