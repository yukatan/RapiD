package org.yukatan.rapid.config.descriptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Data
@ConfigurationProperties(prefix = "api")
public class ApiDescriptorImpl implements ApiDescriptor {

    private String defaultErrorTemplate;
    private String defaultValidationErrorStatus;
    private Map<String,Object> endpoints;
    private JsonNode config;

    @PostConstruct
    public void init(){

        ObjectMapper reader = new ObjectMapper();
        config = reader.valueToTree(endpoints);
    }
}
