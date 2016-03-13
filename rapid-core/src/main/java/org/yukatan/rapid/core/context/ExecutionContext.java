package org.yukatan.rapid.core.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.yukatan.rapid.common.descriptor.RapidDescriptor;
import org.yukatan.rapid.common.scope.RapidScope;
import org.yukatan.rapid.common.task.Task;
import org.yukatan.rapid.phase.Phase;
import org.yukatan.rapid.phase.registry.PhaseRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
public class ExecutionContext {

    List<Task> tasks = new ArrayList<>();

    @Autowired
    private PhaseRegistry phaseRegistry;

    public void bootStrapContext(RapidDescriptor descriptor) {

        phaseRegistry.getPhaseNames().stream()
                .filter(descriptor::containsKey)
                .forEach(phaseName -> {
                    Phase currentPhase = phaseRegistry.getPhase(phaseName);
                    Task task = currentPhase.buildPhase(descriptor.getPhaseDescriptor(phaseName));
                    if (task != null) {
                        tasks.add(task);
                    }
                });

    }

    public void execute(RapidScope scope) {

        for (Task task : tasks) {
            task.execute(scope);
        }
    }


}
