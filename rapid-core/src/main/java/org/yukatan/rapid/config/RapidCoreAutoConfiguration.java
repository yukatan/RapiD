package org.yukatan.rapid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.yukatan.rapid.core.controller.RapidGenericController;
import org.yukatan.rapid.core.descriptor.ApiDescriptor;
import org.yukatan.rapid.core.handler.HandlerBootStrap;
import org.yukatan.rapid.core.handler.RapidRequestHandler;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Configuration
public class RapidCoreAutoConfiguration {

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
    public RapidGenericController rapidGenericController() {

        return new RapidGenericController();
    }

    @Bean
    public HandlerBootStrap handleBootStrap() {

        return new HandlerBootStrap();
    }
}
