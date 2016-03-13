package org.yukatan.rapid.task.validation;

import org.yukatan.rapid.common.scope.RapidScope;
import org.yukatan.rapid.task.ValidationTask;
import org.yukatan.rapid.task.error.ValidationError;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
public abstract class AbstractValidationTask implements ValidationTask {

    protected String scopePath;
    protected LinkedHashMap<String, Object> props;

    public LinkedHashMap<String, Object> getProps() {
        return props;
    }

    public void setProps(LinkedHashMap<String, Object> props) {
        this.props = props;
    }

    public String getScopePath() {
        return scopePath;
    }

    @Override
    public void setScopePath(String scopePath) {
        this.scopePath = scopePath;
    }

    abstract public void execute(RapidScope scope);

    protected void throwError(RapidScope scope) {

        HashMap<String, Object> errorScope = scope.getErrorScope();
        errorScope.putAll(props);
        throw new ValidationError(scope);
    }


}
