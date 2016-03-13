package org.yukatan.rapid.task.validation;

import org.yukatan.rapid.common.scope.RapidScope;
import org.yukatan.rapid.task.ValidationTask;
import org.yukatan.rapid.task.metadata.RapidTask;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
@RapidTask("not-blank")
public class NotBlankValidaton extends AbstractValidationTask implements ValidationTask {

    @Override
    public void execute(RapidScope scope) {

        Object value = scope.getPath(scopePath);
        if(value == null || "".equals(value)){
            throwError(scope);
        }

    }
}
