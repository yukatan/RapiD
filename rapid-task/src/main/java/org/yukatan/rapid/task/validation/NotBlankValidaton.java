package org.yukatan.rapid.task.validation;

import org.springframework.stereotype.Component;
import org.yukatan.rapid.common.model.RapidScope;
import org.yukatan.rapid.task.ValidationTask;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
@Component
public class NotBlankValidaton extends AbstractValidationTask implements ValidationTask {

    @Override
    public void execute(RapidScope scope) {

        Object value = scope.getPath(scopePath);
        if(value == null || "".equals(value)){
            throwError(scope);
        }

    }
}
