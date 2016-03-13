package org.yukatan.rapid.common.descriptor;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@Data
@ConfigurationProperties(prefix = "api")
public class ApiDescriptor {

    private String defaultErrorTemplate;
    private String defaultValidationErrorStatus;
    private List<RapidDescriptor> endpoints;
}
