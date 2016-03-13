package org.yukatan.rapid.phase.registry;

import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.yukatan.rapid.phase.Phase;
import org.yukatan.rapid.phase.metadata.RapidPhase;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jesus Barquín on 13/03/16.
 */
@Component
public class PhaseRegistry {

    @Autowired
    private ApplicationContext context;

    @Setter
    Map<String,Phase> phaseRegistryStore = new LinkedHashMap<>();

    public Collection<String> getPhaseNames(){

        return phaseRegistryStore.keySet();
    }

    public Phase getPhase(String phaseKey){

        return phaseRegistryStore.get(phaseKey);
    }

    @PostConstruct
    public void initializePhaseRegistry(){

        Map<String, Phase> beans = context.getBeansOfType(Phase.class);
        for (Phase phase : beans.values()) {

            RapidPhase taskAnnotation = AnnotationUtils.findAnnotation(phase.getClass(), RapidPhase.class);
            if (taskAnnotation == null) {
                continue;
            }
            phaseRegistryStore.put(taskAnnotation.value(), phase);
        }
    }
}
