package com.yukatan.test.rapid.config.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.yukatan.rapid.config.descriptor.ApiDescriptor;
import org.yukatan.rapid.config.descriptor.ApiDescriptorImpl;
import org.yukatan.rapid.core.controller.ControllerFactory;
import org.yukatan.rapid.core.controller.RapidGenericController;
import org.yukatan.rapid.core.handler.ControllerBootStraper;
import org.yukatan.rapid.core.handler.RapidRequestHandler;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Jesus Barquín on 10/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("config_controller")
@SpringApplicationConfiguration
@WebAppConfiguration
public class ConfigControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;


    @Configuration
    @EnableAutoConfiguration
    static class Config{

        @Bean
        public ApiDescriptor apiDescriptor(){

            return new ApiDescriptorImpl();
        }

        @Bean
        public ControllerBootStraper controllerBootStraper(){

            return new ControllerBootStraper();
        }

        @Bean
        public RapidRequestHandler rapidRequestHandler(){

            return new RapidRequestHandler();
        }

        @Bean
        public ControllerFactory controllerFactory(){

            return new ControllerFactory();
        }

        @Bean
        @Scope("prototype")
        public RapidGenericController rapidGenericController(){

            return new RapidGenericController();
        }
    }

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testDescriptorContent() throws Exception {

        mockMvc.perform(get("/controller/test")).andDo(print()).andExpect(status().isOk());
    }

}
