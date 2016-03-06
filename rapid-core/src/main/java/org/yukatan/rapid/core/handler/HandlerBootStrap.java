package org.yukatan.rapid.core.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.yukatan.rapid.core.controller.RapidGenericController;
import org.yukatan.rapid.core.descriptor.ApiDescriptor;
import org.yukatan.rapid.core.descriptor.RapidDescriptor;
import org.yukatan.rapid.task.DefaultSequentialTaskImpl;
import org.yukatan.rapid.task.Task;
import org.yukatan.rapid.task.ValidationTask;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

        for (RapidDescriptor endPointDescriptor : apiDescriptor.getEndpoints()) {

            registerEndPointHandler(endPointDescriptor);
        }
    }

    private void registerEndPointHandler(RapidDescriptor endpointDescriptor) {

        RapidGenericController controller = context.getBean(RapidGenericController.class);
        LinkedHashMap<String,Object> validation = endpointDescriptor.getValidation();
        if (validation != null) {
            Task validationChain = buildValidationChain(validation);
            controller.setTaskChain(validationChain);
        }
        rapidRequestHandler.registerHandlerMethod(controller, getHandlerMethod(controller), RequestMappingInfoBuilder.build(endpointDescriptor));
    }

    private Method getHandlerMethod(RapidGenericController controller) {

        try {
            return controller.getClass().getMethod("handle", Map.class, Map.class, Map.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private Task buildValidationChain(LinkedHashMap<String,Object> descriptor) {

        List<Task> task = new ArrayList<>();
        for(String key: descriptor.keySet()){

            LinkedHashMap<String,Object> validationDescriptor = (LinkedHashMap<String, Object>) descriptor.get(key);
            ValidationTask validationTask = context.getBean(validationDescriptor.get("type").toString(),ValidationTask.class);
            validationTask.setScopePath(validationDescriptor.get("scopePath").toString());
            validationTask.setProps((LinkedHashMap<String, Object>) validationDescriptor.get("props"));
            task.add(validationTask);
        }
        return new DefaultSequentialTaskImpl(task);
    }

}
