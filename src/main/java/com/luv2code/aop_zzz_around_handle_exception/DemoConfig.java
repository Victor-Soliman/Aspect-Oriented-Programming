package com.luv2code.aop_zzz_around_handle_exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  // important to place here
@ComponentScan("com.luv2code.aop_zzz_around_handle_exception") // the package name where i need spring to scan ad find the bean
public class DemoConfig {
}
