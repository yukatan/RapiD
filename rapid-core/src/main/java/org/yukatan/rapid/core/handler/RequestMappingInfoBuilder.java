package org.yukatan.rapid.core.handler;

import lombok.Builder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.yukatan.rapid.common.descriptor.RapidDescriptor;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Builder
public class RequestMappingInfoBuilder {

    public static RequestMappingInfo build(RapidDescriptor descriptor) {

        PatternsRequestCondition patternRequestCondition = createPatternRequestCondition(descriptor);
        RequestMethodsRequestCondition requestMethodsRequestCondition = createRequestMethodsRequestCondition(descriptor);
        return new RequestMappingInfo("name", patternRequestCondition, requestMethodsRequestCondition, null, null, null, null, null);
    }

    private static PatternsRequestCondition createPatternRequestCondition(RapidDescriptor descriptor) {

        String path = descriptor.getString("path");
        return new PatternsRequestCondition(path);
    }

    private static RequestMethodsRequestCondition createRequestMethodsRequestCondition(RapidDescriptor descriptor) {

        String method = descriptor.getString("method");
        switch (method.toUpperCase()) {

            case "GET":
                return new RequestMethodsRequestCondition(RequestMethod.GET);
            case "POST":
                return new RequestMethodsRequestCondition(RequestMethod.POST);
            default:
                return new RequestMethodsRequestCondition(RequestMethod.GET);
        }
    }
}


