package org.yukatan.rapid.core.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yukatan.rapid.common.scope.RapidScope;
import org.yukatan.rapid.common.task.Task;
import org.yukatan.rapid.core.context.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@ResponseBody
@AllArgsConstructor
public class RapidGenericController {

    @NonNull
    private ExecutionContext executionContext;

    public ResponseEntity handle(@RequestParam(required = false) Map<String, Object> params,
                                 @RequestBody(required = false) Map<String, Object> body,
                                 @RequestHeader(required = false) Map<String, Object> headers) {

        RapidScope scope = RapidScope.create();
        HashMap<String, Object> requestScope = scope.getRequestScope();
        requestScope.put("headers", headers);
        requestScope.put("params", params);
        executionContext.execute(scope);
        return ResponseEntity.ok("{\"result\":\"YEAH\"}");
    }


}
