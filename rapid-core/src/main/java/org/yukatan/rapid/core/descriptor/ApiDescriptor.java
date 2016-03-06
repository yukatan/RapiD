package org.yukatan.rapid.core.descriptor;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@ConfigurationProperties(prefix = "api")
public class ApiDescriptor {

    private String defaultErrorTemplate;
    private String defaultValidationErrorStatus;
    private List<RapidDescriptor> endpoints;

    public List<RapidDescriptor> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<RapidDescriptor> endpoints) {
        this.endpoints = endpoints;
    }

    public String getDefaultErrorTemplate() {
        return defaultErrorTemplate;
    }

    public void setDefaultErrorTemplate(String defaultErrorTemplate) {
        this.defaultErrorTemplate = defaultErrorTemplate;
    }

    public String getDefaultValidationErrorStatus() {
        return defaultValidationErrorStatus;
    }

    public void setDefaultValidationErrorStatus(String defaultValidationErrorStatus) {
        this.defaultValidationErrorStatus = defaultValidationErrorStatus;
    }
}
