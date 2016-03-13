package org.yukatan.rapid.task.registry;

import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.yukatan.rapid.common.task.Task;
import org.yukatan.rapid.task.error.TaskKeyExistException;
import org.yukatan.rapid.task.metadata.RapidTask;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
@Component
public class TaskRegistry {

    @Setter
    private Map<String, Task> taskRegistryStore = new HashMap<>();

    @Autowired
    private ApplicationContext context;

    public void registerTask(String key, Task task) {

        if (taskRegistryStore.containsKey(key)) {

            throw new TaskKeyExistException("The task key: " + key + " is duplicated");
        }
        taskRegistryStore.put(key, task);
    }

    public Task getTask(String key) {

        //// TODO: 13/03/16 Throw exception if task does not exists
        return taskRegistryStore.get(key);
    }


    @PostConstruct
    public void initializeTaskRegistry() {

        Map<String, Task> beans = context.getBeansOfType(Task.class);
        for (Task task : beans.values()) {

            RapidTask taskAnnotation = AnnotationUtils.findAnnotation(task.getClass(), RapidTask.class);
            if (taskAnnotation == null) {
                continue;
            }
            taskRegistryStore.put(taskAnnotation.value(), task);
        }
    }
}
