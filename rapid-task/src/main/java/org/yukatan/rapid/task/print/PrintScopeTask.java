package org.yukatan.rapid.task.print;

import org.yukatan.rapid.common.scope.RapidScope;
import org.yukatan.rapid.common.task.Task;
import org.yukatan.rapid.task.metadata.RapidTask;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@RapidTask("print-scope")
public class PrintScopeTask implements Task {

    @Override
    public void execute(RapidScope scope) {

        System.out.print(scope);
    }
}
