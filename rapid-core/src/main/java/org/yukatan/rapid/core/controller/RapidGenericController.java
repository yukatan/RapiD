package org.yukatan.rapid.core.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@ResponseBody
public class RapidGenericController {

    private ObjectMapper mapper = new ObjectMapper();

    public ResponseEntity handle(@RequestParam(required = false) Map<String, Object> params,
                                 @RequestBody(required = false) Map<String, Object> body,
                                 @RequestHeader(required = false) Map<String, Object> headers) {

        JsonNode scope = createNodeScope(params,body,headers);
        return ResponseEntity.ok("{\"result\":\"YEAH\"}");
    }

    private JsonNode createNodeScope(Map<String, Object> params, Map<String, Object> body, Map<String, Object> headers){

        ObjectNode scope = mapper.createObjectNode();
        scope.with("request").set("headers",mapper.valueToTree(headers));
        return scope;
    }

}
