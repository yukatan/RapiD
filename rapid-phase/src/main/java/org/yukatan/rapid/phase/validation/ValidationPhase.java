package org.yukatan.rapid.phase.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.yukatan.rapid.common.task.Task;
import org.yukatan.rapid.phase.Phase;
import org.yukatan.rapid.phase.metadata.RapidPhase;
import org.yukatan.rapid.task.DefaultSequentialTaskImpl;
import org.yukatan.rapid.task.ValidationTask;
import org.yukatan.rapid.task.registry.TaskRegistry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
@RapidPhase("validation")
public class ValidationPhase implements Phase{

    @Autowired
    private TaskRegistry taskRegistry;

    @Override
    public Task buildPhase(LinkedHashMap<String,Object> descriptor) {

        List<Task> task = new ArrayList<>();
        for(String key: descriptor.keySet()){

            LinkedHashMap<String,Object> validationDescriptor = (LinkedHashMap<String, Object>) descriptor.get(key);
            ValidationTask validationTask = (ValidationTask) taskRegistry.getTask(validationDescriptor.get("type").toString());
            validationTask.setScopePath(validationDescriptor.get("scopePath").toString());
            validationTask.setProps((LinkedHashMap<String, Object>) validationDescriptor.get("props"));
            task.add(validationTask);
        }
        return new DefaultSequentialTaskImpl(task);
    }
}
