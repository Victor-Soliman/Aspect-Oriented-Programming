package com.luv2code.aop_zz_around;

import com.luv2code.aop_zz_around.dao.AccountDAO;
import com.luv2code.aop_zz_around.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class AroundDemoApp {
    public static void main(String[] args) {
        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        TrafficFortuneService theFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");

        System.out.println("Calling getFortune");

        String data = theFortuneService.getFortune();

        System.out.println("\nMy fortune is : " + data);

        System.out.println("Finished");

        context.close();

    }
}
