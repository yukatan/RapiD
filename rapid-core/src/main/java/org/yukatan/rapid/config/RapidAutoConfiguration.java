package org.yukatan.rapid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yukatan.rapid.core.descriptor.ApiDescriptor;
import org.yukatan.rapid.core.handler.RapidRequestHandler;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Configuration
public class RapidAutoConfiguration {

    @Bean
    public RapidRequestHandler rapidRequestHandler(){

        return new RapidRequestHandler();
    }

    @Bean
    public ApiDescriptor apiDescriptor(){

        return new ApiDescriptor();
    }
}
