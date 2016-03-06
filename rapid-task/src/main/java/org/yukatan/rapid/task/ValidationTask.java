package org.yukatan.rapid.task;

import java.util.LinkedHashMap;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
public interface ValidationTask extends Task {

    void setScopePath(String scopePath);

    void setProps(LinkedHashMap<String, Object> props);
}
