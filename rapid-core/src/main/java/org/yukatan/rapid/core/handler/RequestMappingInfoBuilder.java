package org.yukatan.rapid.core.handler;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Builder
public class RequestMappingInfoBuilder {

    public static RequestMappingInfo build(JsonNode descriptor) {

        PatternsRequestCondition patternRequestCondition = createPatternRequestCondition(descriptor);
        RequestMethodsRequestCondition requestMethodsRequestCondition = createRequestMethodsRequestCondition(descriptor);
        return new RequestMappingInfo("name", patternRequestCondition, requestMethodsRequestCondition, null, null, null, null, null);
    }

    private static PatternsRequestCondition createPatternRequestCondition(JsonNode descriptor) {

        String path = descriptor.at("/definition/path").asText();
        return new PatternsRequestCondition(path);
    }

    private static RequestMethodsRequestCondition createRequestMethodsRequestCondition(JsonNode descriptor) {

        String method = descriptor.at("/definition/method").asText().toUpperCase();
        switch (method) {

            case "GET":
                return new RequestMethodsRequestCondition(RequestMethod.GET);
            case "POST":
                return new RequestMethodsRequestCondition(RequestMethod.POST);
            case "PUT":
                return new RequestMethodsRequestCondition(RequestMethod.PUT);
            case "DELETE":
                return new RequestMethodsRequestCondition(RequestMethod.DELETE);
            default:
                return new RequestMethodsRequestCondition(RequestMethod.GET);
        }
    }
}


