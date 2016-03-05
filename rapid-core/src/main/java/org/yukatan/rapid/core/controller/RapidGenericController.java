package org.yukatan.rapid.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yukatan.rapid.common.model.RapidScope;
import org.yukatan.rapid.task.Task;

import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@ResponseBody
public class RapidGenericController {

    private Task taskChain;

    public ResponseEntity handle(@RequestParam(required = false) Map<String,String> params,
                                 @RequestBody(required = false) Map<String,Object> body,
                                 @RequestHeader(required = false) Map<String,String> headers){

        RapidScope scope = new RapidScope();
        scope.setHeaders(headers);
        scope.setParams(params);
        if(taskChain != null) {
            taskChain.execute(scope);
        }
        return ResponseEntity.ok("{\"result\":\"YEAH\"}");
    }

    public void setTaskChain(Task taskChain) {
        this.taskChain = taskChain;
    }
}
