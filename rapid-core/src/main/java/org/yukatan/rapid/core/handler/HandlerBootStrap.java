package org.yukatan.rapid.core.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.yukatan.rapid.common.descriptor.ApiDescriptor;
import org.yukatan.rapid.common.descriptor.RapidDescriptor;
import org.yukatan.rapid.core.context.ExecutionContext;
import org.yukatan.rapid.core.context.ExecutionContextFactory;
import org.yukatan.rapid.core.controller.ControllerFactory;
import org.yukatan.rapid.core.controller.RapidGenericController;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Slf4j
public class HandlerBootStrap {

    @Autowired
    private ApiDescriptor apiDescriptor;

    @Autowired
    private RapidRequestHandler rapidRequestHandler;

    @Autowired
    private ExecutionContextFactory executionContextFactory;

    @Autowired
    private ControllerFactory controllerFactory;

    @PostConstruct
    public void start() {

        for (RapidDescriptor descriptor : apiDescriptor.getEndpoints()) {

            ExecutionContext executionContext = executionContextFactory.create();
            executionContext.bootStrapContext(descriptor);
            RapidGenericController controller = controllerFactory.create(executionContext);
            rapidRequestHandler.registerHandlerMethod(controller, getHandlerMethod(controller), RequestMappingInfoBuilder.build(descriptor));
        }
    }

    private Method getHandlerMethod(RapidGenericController controller) {

        try {
            return controller.getClass().getMethod("handle", Map.class, Map.class, Map.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

}
