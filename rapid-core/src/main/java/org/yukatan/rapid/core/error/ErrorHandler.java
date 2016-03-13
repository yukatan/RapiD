package org.yukatan.rapid.core.error;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.trimou.Mustache;
import org.trimou.engine.MustacheEngineBuilder;
import org.yukatan.rapid.common.scope.RapidScope;
import org.yukatan.rapid.common.descriptor.ApiDescriptor;
import org.yukatan.rapid.task.error.ValidationError;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
@ControllerAdvice
@ResponseBody
public class ErrorHandler {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ApiDescriptor apiDescriptor;


    private String defaultErrorTemplate;

    @ExceptionHandler(value = ValidationError.class)
    public ResponseEntity<String> handleValidationError(ValidationError error){

        RapidScope scope = error.getScope();
        Mustache mustache = MustacheEngineBuilder
                .newBuilder()
                .build()
                .compileMustache("errorTemplate",defaultErrorTemplate);
        String result = mustache.render(scope).replaceAll("\\n","");
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.valueOf(Integer.valueOf(apiDescriptor.getDefaultValidationErrorStatus()))).body(result);
        return response;
    }

    @PostConstruct
    public void initErrorTemplate() {

        Resource template = context.getResource("classpath:" + apiDescriptor.getDefaultErrorTemplate());
        try {
           this.defaultErrorTemplate = IOUtils.toString(template.getInputStream()).replaceAll(" ","");
        } catch (IOException e) {
            this.defaultErrorTemplate = null;
        }

    }
}
