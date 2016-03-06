package org.yukatan.rapid.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.*;
import org.yukatan.rapid.task.print.PrintScopeTask;
import org.yukatan.rapid.task.validation.IfPresentValidation;
import org.yukatan.rapid.task.validation.NotBlankValidaton;
import org.yukatan.rapid.task.validation.NotNullValidation;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Configuration
@AutoConfigureBefore(RapidCoreAutoConfiguration.class)
@ComponentScan(basePackages = "org.yukatan.rapid.task.validation")
@Import(TaskRegistryConfiguration.class)
public class RapidTaskAutoConfiguration {

    @Bean(name = "print-scope")
    @Scope("prototype")
    public PrintScopeTask printScopeTask(){

        return new PrintScopeTask();
    }

    @Bean(name = "notNull")
    @Scope("prototype")
    public NotNullValidation notNullValidation(){

        return new NotNullValidation();
    }

    @Bean(name = "ifPresent")
    @Scope("prototype")
    public IfPresentValidation ifPresentValidation(){

        return new IfPresentValidation();
    }

    @Bean(name = "notBlank")
    @Scope("prototype")
    public NotBlankValidaton notBlankValidaton(){

        return new NotBlankValidaton();
    }
}
