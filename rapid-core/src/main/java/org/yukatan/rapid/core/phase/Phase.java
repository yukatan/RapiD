package org.yukatan.rapid.core.phase;

import com.fasterxml.jackson.databind.JsonNode;
import org.yukatan.rapid.core.task.Task;

import java.util.LinkedHashMap;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
public interface Phase {

    Task buildPhase(JsonNode descriptor);
}
