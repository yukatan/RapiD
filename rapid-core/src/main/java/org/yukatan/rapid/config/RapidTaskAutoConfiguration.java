package org.yukatan.rapid.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.yukatan.rapid.task.print.PrintScopeTask;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Configuration
public class RapidTaskAutoConfiguration {

    @Bean(name = "print-scope")
    @Scope("prototype")
    public PrintScopeTask printScopeTask(){

        return new PrintScopeTask();
    }

}
