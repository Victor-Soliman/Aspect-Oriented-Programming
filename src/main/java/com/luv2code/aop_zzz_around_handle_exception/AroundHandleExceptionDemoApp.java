package com.luv2code.aop_zzz_around_handle_exception;

import com.luv2code.aop_zzz_around_handle_exception.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundHandleExceptionDemoApp {
    public static void main(String[] args) {

         Logger myLogger =
                Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        TrafficFortuneService theFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program: AroundDemoApp");

        myLogger.info("Calling getFortune");

        boolean tripWire = true;
        String data = theFortuneService.getFortune(tripWire);

        myLogger.info("\nMy fortune is : " + data);

        myLogger.info("Finished");

        // close the context
        context.close();

    }
}
