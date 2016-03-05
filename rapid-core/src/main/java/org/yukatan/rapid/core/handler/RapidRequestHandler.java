package org.yukatan.rapid.core.handler;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class RapidRequestHandler extends RequestMappingHandlerMapping {


    @Override
    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
        super.registerHandlerMethod(handler, method, mapping);
    }

}
