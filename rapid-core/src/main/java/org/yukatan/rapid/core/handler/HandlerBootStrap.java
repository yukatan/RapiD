package org.yukatan.rapid.core.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.yukatan.rapid.core.controller.RapidGenericController;
import org.yukatan.rapid.core.descriptor.ApiDescriptor;
import org.yukatan.rapid.core.descriptor.EndPointDescriptor;
import org.yukatan.rapid.core.descriptor.TaskDescriptor;
import org.yukatan.rapid.task.DefaultSequentialTaskImpl;
import org.yukatan.rapid.task.Task;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class HandlerBootStrap {

    @Autowired
    private ApiDescriptor apiDescriptor;

    @Autowired
    private RapidRequestHandler rapidRequestHandler;

    @Autowired
    private ApplicationContext context;


    @PostConstruct
    public void start() {

        for (EndPointDescriptor descriptor : apiDescriptor.getEndpoints()) {

            registerEndPointHandler(descriptor);
        }
    }

    private void registerEndPointHandler(EndPointDescriptor descriptor) {

        RapidGenericController controller = context.getBean(RapidGenericController.class);
        if(descriptor.getTasks() != null && !descriptor.getTasks().isEmpty()) {
            controller.setTaskChain(buildTaskChain(descriptor));
        }
        rapidRequestHandler.registerHandlerMethod(controller, getHandlerMethod(controller), RequestMappingInfoBuilder.build(descriptor));
    }

    private Method getHandlerMethod(RapidGenericController controller) {

        try {
            return controller.getClass().getMethod("handle", Map.class,Map.class,Map.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private Task buildTaskChain(EndPointDescriptor descriptor){

        List<Task> task = new ArrayList<Task>();
        for (TaskDescriptor taskDescriptor: descriptor.getTasks()){

            task.add(context.getBean(taskDescriptor.getType(),Task.class));
        }
        return new DefaultSequentialTaskImpl(task);
    }

}
