package org.yukatan.rapid.task.print;

import org.yukatan.rapid.common.model.RapidScope;
import org.yukatan.rapid.task.Task;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class PrintScopeTask implements Task {

    @Override
    public void execute(RapidScope scope) {

        System.out.print(scope);
    }
}
