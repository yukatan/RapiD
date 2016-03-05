package org.yukatan.rapid.core.descriptor;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@ConfigurationProperties(prefix = "api")
public class ApiDescriptor {

    List<EndPointDescriptor> endpoints = new ArrayList<>();

    public List<EndPointDescriptor> getEndpoints() {
        return endpoints;
    }
}
