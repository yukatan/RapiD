package org.yukatan.rapid.task.error;

import org.yukatan.rapid.common.model.RapidScope;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
public class ValidationError extends RuntimeException {

    private RapidScope scope;

    public ValidationError(RapidScope scope) {
        this.scope = scope;
    }

    public RapidScope getScope() {
        return scope;
    }
}
