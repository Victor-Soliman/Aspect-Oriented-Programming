package com.luv2code.aop_zz_around_with_logger;

import com.luv2code.aop_zz_around_with_logger.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundWithLoggerDemoApp {
    public static void main(String[] args) {

         Logger myLogger =
                Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        TrafficFortuneService theFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program: AroundDemoApp");

        myLogger.info("Calling getFortune");

        String data = theFortuneService.getFortune();

        myLogger.info("\nMy fortune is : " + data);

        myLogger.info("Finished");

        // close the context
        context.close();

    }
}
