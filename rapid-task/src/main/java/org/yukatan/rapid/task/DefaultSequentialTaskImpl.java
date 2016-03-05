package org.yukatan.rapid.task;

import org.yukatan.rapid.common.model.RapidScope;

import java.util.List;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class DefaultSequentialTaskImpl implements SequentialTask {

    private List<Task> tasks;

    public DefaultSequentialTaskImpl(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute(RapidScope scope) {

        for( Task currentTask : tasks){

            currentTask.execute(scope);
        }
    }
}
