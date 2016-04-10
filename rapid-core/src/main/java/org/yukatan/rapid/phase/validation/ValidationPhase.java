package org.yukatan.rapid.phase.validation;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.yukatan.rapid.core.exception.RequiredFieldException;
import org.yukatan.rapid.core.phase.Phase;
import org.yukatan.rapid.core.phase.metadata.RapidPhase;
import org.yukatan.rapid.core.task.Task;
import org.yukatan.rapid.core.task.registry.TaskRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
@RapidPhase("validation")
public class ValidationPhase implements Phase{

    public static final String REQUIRED_FIELD_NOT_PRESENT = "Required field scopePath is not present in validation constraint";

    @Autowired
    private TaskRegistry taskRegistry;

    @Override
    public Task buildPhase(JsonNode descriptor) {

        List<Task> task = new ArrayList<>();
        descriptor.iterator().forEachRemaining(this::processConstraint);
        return null;
    }

    private void processConstraint(JsonNode contraint) {

        String scopePath = contraint.path("scopePath").asText();
        if(StringUtils.hasText(scopePath)){
            throw new RequiredFieldException(REQUIRED_FIELD_NOT_PRESENT);
        }

    }
}
