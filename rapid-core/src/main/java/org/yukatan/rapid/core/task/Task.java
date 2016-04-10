package org.yukatan.rapid.core.task;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public interface Task {

    void execute(JsonNode scope);
 }
