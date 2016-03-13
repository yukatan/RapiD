package org.yukatan.rapid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.yukatan.rapid.common.descriptor.ApiDescriptor;
import org.yukatan.rapid.core.context.ExecutionContext;
import org.yukatan.rapid.core.controller.RapidGenericController;
import org.yukatan.rapid.core.error.ErrorHandler;
import org.yukatan.rapid.core.handler.HandlerBootStrap;
import org.yukatan.rapid.core.handler.RapidRequestHandler;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Configuration
@ComponentScan(basePackages = "org.yukatan.rapid")
public class RapidCoreAutoConfiguration {

    @Autowired
    private ApiDescriptor apiDescriptor;

    @Bean
    public RapidRequestHandler rapidRequestHandler() {

        RapidRequestHandler handler = new RapidRequestHandler();
        handler.setOrder(Integer.MIN_VALUE);
        return handler;
    }

    @Bean
    public ApiDescriptor apiDescriptor() {

        return new ApiDescriptor();
    }

    @Bean
    @Scope("prototype")
    public RapidGenericController rapidGenericController(ExecutionContext executionContext) {

        return new RapidGenericController(executionContext);
    }

    @Bean
    public HandlerBootStrap handleBootStrap() {

        return new HandlerBootStrap();
    }

    @Bean
    public ErrorHandler errorHandler() {

        return new ErrorHandler();
    }

    @Bean
    @Scope("prototype")
    public ExecutionContext executionContext(){

        return new ExecutionContext();
    }

}
