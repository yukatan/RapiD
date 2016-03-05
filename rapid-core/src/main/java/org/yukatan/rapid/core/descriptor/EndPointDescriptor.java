package org.yukatan.rapid.core.descriptor;

import java.util.List;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class EndPointDescriptor {

    private String path;
    private String method;
    private List<TaskDescriptor> tasks;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<TaskDescriptor> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDescriptor> tasks) {
        this.tasks = tasks;
    }
}
