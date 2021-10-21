package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

//public class TestingBeans {

//@SpringBootApplication //equivalent to three other annotations: Configuration, EnableAutoConfiguration, ComponentScan
////@Configuration basically tells spring that there are components definitions for spring to process. Spring then looks for @Bean annotations
////@EnableAutoConfiguration tells spring to automatically match components (@Bean method return values saved in application context) with dependencies (args e.g compoundMessage)
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(ReviewApplication.class, args);
//    }
//
//    @Primary
//    @Bean
//    public String basicMessage() {
//        System.out.println("basicMessage called automatically because class is annotated\n" +
//                "with configuration and method with bean therefore adding this to the application context");
//        return "Hello World";
//    }
//
//    @Bean
//    public String compoundMessage(String basicMessage) {
//        System.out.println("compound message will be called with basicMessage bean passed as arg(injected) from the Application " +
//                "context\nThis is the value of compoundMessage: "+ basicMessage);
//        return basicMessage + ", Spring!";
//    }
//
//    @Bean
//    public int characterCount(String message) {//basicMessage would be injected here because of the @primary annotation
//        System.out.println("Message count is "+ message.length());
//        return message.length();
//    }
//}
//

