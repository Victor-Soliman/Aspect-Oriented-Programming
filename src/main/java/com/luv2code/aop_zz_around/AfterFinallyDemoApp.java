package com.luv2code.aop_zz_around;

import com.luv2code.aop_zz_around.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts

        List<Account> theAccounts = null;

        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exe) {
            System.out.println("\n\nMain Program ... caught exception : " + exe);
        }
        // display the accounts
        System.out.println("\n\nMain Program: After ThrowingDemoApp");
        System.out.println("-----");

        System.out.println(theAccounts);
        System.out.println("\n");


        context.close();

    }
}
