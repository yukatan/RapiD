package org.yukatan.rapid.core.handler;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.yukatan.rapid.core.descriptor.EndPointDescriptor;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class RequestMappingInfoBuilder {

    public static RequestMappingInfo build(EndPointDescriptor descriptor) {

        PatternsRequestCondition patternRequestCondition = createPatternRequestCondition(descriptor);
        RequestMethodsRequestCondition requestMethodsRequestCondition = createRequestMethodsRequestCondition(descriptor);
        return new RequestMappingInfo("name", patternRequestCondition, requestMethodsRequestCondition, null, null, null, null, null);
    }

    private static PatternsRequestCondition createPatternRequestCondition(EndPointDescriptor descriptor) {

        return new PatternsRequestCondition(descriptor.getPath());
    }

    private static RequestMethodsRequestCondition createRequestMethodsRequestCondition(EndPointDescriptor descriptor) {

        switch (descriptor.getMethod().toUpperCase()) {

            case "GET":
                return new RequestMethodsRequestCondition(RequestMethod.GET);
            case "POST":
                return new RequestMethodsRequestCondition(RequestMethod.POST);
            default:
                return new RequestMethodsRequestCondition(RequestMethod.GET);
        }
    }
}


