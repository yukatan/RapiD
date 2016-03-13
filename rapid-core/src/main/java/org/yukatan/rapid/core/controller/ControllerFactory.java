package org.yukatan.rapid.core.controller;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import org.yukatan.rapid.core.context.ExecutionContext;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
@Component
public class ControllerFactory {

    @Lookup
    public RapidGenericController create(ExecutionContext context){
        return null;
    }
}
