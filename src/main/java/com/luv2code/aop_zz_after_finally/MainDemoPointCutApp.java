package com.luv2code.aop_zz_after_finally;

import com.luv2code.aop_zz_after_finally.dao.AccountDAO;
import com.luv2code.aop_zz_after_finally.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainDemoPointCutApp {
    public static void main(String[] args) {
        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        // call membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

        // VERY IMPORTANT : here the advice is running on the background before calling our business method
        // call the business method

        Account myAccount = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");

        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        // call the accountDao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();


        context.close();


    }
}
