package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainDemoApp {
    public static void main(String[] args) {
        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // VERY IMPORTANT : here the advice is running on the background before calling our business method
        // call the business method

        theAccountDAO.addAccount();

        // do it again!
        System.out.println("\n let's call it again! \n");

        // VERY IMPORTANT : here the advice is running on the background before calling our business method
        // call the business method again

        theAccountDAO.addAccount();

        // close the context

        context.close();


    }
}
