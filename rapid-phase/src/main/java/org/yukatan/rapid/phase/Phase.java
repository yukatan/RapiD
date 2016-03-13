package org.yukatan.rapid.phase;

import org.yukatan.rapid.common.task.Task;

import java.util.LinkedHashMap;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
public interface Phase {

    Task buildPhase(LinkedHashMap<String,Object> descriptor);
}
