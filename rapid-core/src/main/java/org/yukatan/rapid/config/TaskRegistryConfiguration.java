package org.yukatan.rapid.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.yukatan.rapid.task.Task;

import java.util.Map;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
@Configuration
public class TaskRegistryConfiguration implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        Map<String,Task> beans = configurableListableBeanFactory.getBeansOfType(Task.class);
        System.out.print("");
        return;
    }
}
