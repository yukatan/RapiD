package org.yukatan.rapid.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
public class ControllerFactory {

    @Autowired
    private ApplicationContext context;

    public RapidGenericController create() {

        return context.getBean(RapidGenericController.class);
    }
}
