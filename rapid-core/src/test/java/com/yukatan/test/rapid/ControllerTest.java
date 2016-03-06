package com.yukatan.test.rapid;

import com.yukatan.TestApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("controller")
@SpringApplicationConfiguration(classes = TestApp.class)
@WebAppConfiguration
public class ControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testControllerInvokeGet() throws Exception {

        mockMvc.perform(get("/controller/test")).andExpect(status().isOk());
    }

    @Test
    public void testControllerHeaders() throws Exception {

        mockMvc.perform(get("/controller/headers").header("empty-header","test-header-value")).andExpect(status().isOk());
    }
}
