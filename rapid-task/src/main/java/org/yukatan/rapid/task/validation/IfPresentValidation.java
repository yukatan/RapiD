package org.yukatan.rapid.task.validation;

import org.yukatan.rapid.common.model.RapidScope;
import org.yukatan.rapid.task.ValidationTask;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
public class IfPresentValidation extends AbstractValidationTask implements ValidationTask {

    @Override
    public void execute(RapidScope scope) {

        boolean exist = scope.containsKey(scopePath);
        if(!exist){
            throwError(scope);
        }
    }

}
