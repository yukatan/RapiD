package org.yukatan.rapid.core.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.yukatan.rapid.config.descriptor.ApiDescriptor;
import org.yukatan.rapid.core.controller.ControllerFactory;
import org.yukatan.rapid.core.controller.RapidGenericController;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Slf4j
public class ControllerBootStraper {

    @Autowired
    private ApiDescriptor apiDescriptor;

    @Autowired
    private RapidRequestHandler rapidRequestHandler;

    @Autowired
    private ControllerFactory controllerFactory;


    @PostConstruct
    public void start() {

        apiDescriptor.getConfig().iterator().forEachRemaining(endpoint -> {

            RapidGenericController controller = controllerFactory.create();
            rapidRequestHandler.registerHandlerMethod(controller, getHandlerMethod(controller), RequestMappingInfoBuilder.build(endpoint));
        });
    }

    private Method getHandlerMethod(RapidGenericController controller) {

        try {
            return controller.getClass().getMethod("handle", Map.class, Map.class, Map.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

}
