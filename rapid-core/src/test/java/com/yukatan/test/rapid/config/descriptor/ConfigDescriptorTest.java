package com.yukatan.test.rapid.config.descriptor;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.yukatan.rapid.config.descriptor.ApiDescriptor;
import org.yukatan.rapid.config.descriptor.ApiDescriptorImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Jesus Barquín on 10/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("config_descriptor")
@SpringApplicationConfiguration
@WebAppConfiguration
public class ConfigDescriptorTest {

    @Autowired
    private ApiDescriptor descriptor;


    @Configuration
    @EnableAutoConfiguration
    static class Config{

        @Bean
        public ApiDescriptor apiDescriptor(){

            return new ApiDescriptorImpl();
        }
    }

    @Test
    public void testDescriptorContent() throws Exception {

        assertNotNull(descriptor);
        assertNotNull(descriptor.getConfig());
    }

    @Test
    public void testConfigContent() throws Exception {

        JsonNode config = descriptor.getConfig();
        assertFalse(config.at("/test/definition/path").isMissingNode());
        assertEquals("/controller/test",config.at("/test/definition/path").asText());
        assertEquals("GET",config.at("/test/definition/method").asText());
    }

    @Test
    public void testConfigContentValidationPhase() throws Exception {

        JsonNode config = descriptor.getConfig();
        assertFalse(config.at("/test/validation/not-null").isMissingNode());
        assertEquals(400,config.at("/test/validation/not-null/code").asInt());
        assertEquals("request.headers.test-header",config.at("/test/validation/not-null/scopePath").asText());
    }

}
