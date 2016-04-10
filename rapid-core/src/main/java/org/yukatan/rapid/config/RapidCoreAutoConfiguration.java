//package org.yukatan.rapid.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.yukatan.rapid.config.descriptor.ApiDescriptor;
//import org.yukatan.rapid.core.controller.RapidGenericController;
//import org.yukatan.rapid.core.handler.ControllerBootStraper;
//import org.yukatan.rapid.core.handler.RapidRequestHandler;
//
///**
// * Created by Jesus Barquín on 5/03/16.
// */
//@Configuration
//@ComponentScan(basePackages = "org.yukatan.rapid")
//public class RapidCoreAutoConfiguration {
//
//    @Autowired
//    private ApiDescriptor apiDescriptor;
//
//    @Bean
//    public RapidRequestHandler rapidRequestHandler() {
//
//        RapidRequestHandler handler = new RapidRequestHandler();
//        handler.setOrder(Integer.MIN_VALUE);
//        return handler;
//    }
//
//    @Bean
//    public ApiDescriptor apiDescriptor() {
//
//        return new ApiDescriptor();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public RapidGenericController rapidGenericController(){
//
//        return new RapidGenericController();
//    }
//
//    @Bean
//    public ControllerBootStraper handleBootStrap() {
//
//        return new ControllerBootStraper();
//    }
//
////    @Bean
////    public ErrorHandler errorHandler() {
////
////        return new ErrorHandler();
////    }
////
////    @Bean
////    @Scope("prototype")
////    public ExecutionContext executionContext(){
////
////        return new ExecutionContext();
////    }
//
//}
