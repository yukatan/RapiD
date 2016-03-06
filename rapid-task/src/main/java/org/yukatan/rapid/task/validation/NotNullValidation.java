package org.yukatan.rapid.task.validation;

import org.yukatan.rapid.common.model.RapidScope;
import org.yukatan.rapid.task.ValidationTask;
import org.yukatan.rapid.task.error.ValidationError;

import java.util.HashMap;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
public class NotNullValidation extends AbstractValidationTask implements ValidationTask {

    @Override
    public void execute(RapidScope scope) {

        Object scopeValue = scope.getPath(scopePath);
        if(scopeValue == null){
            throwError(scope);
        }
    }

}
