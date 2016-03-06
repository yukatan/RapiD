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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Jesus Barquín on 6/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("validation")
@SpringApplicationConfiguration(classes = TestApp.class)
@WebAppConfiguration
public class ValidationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testNotNullValidation() throws Exception {

        mockMvc.perform(get("/validation/headers/notnull").header("null-header","test-header-value")).andExpect(status().isOk());
        mockMvc.perform(get("/validation/headers/notnull")).andExpect(status().isBadRequest()).andDo(print());
    }

    @Test
    public void testIfPresentValidation() throws Exception {

        mockMvc.perform(get("/validation/headers/ifpresent").header("present-header","test-header-value")).andExpect(status().isOk());
        mockMvc.perform(get("/validation/headers/ifpresent")).andExpect(status().isBadRequest()).andDo(print());
    }

    @Test
    public void testNotBlankValidation() throws Exception {

        mockMvc.perform(get("/validation/headers/notblank").header("blank-header","test-header-value")).andExpect(status().isOk());
        mockMvc.perform(get("/validation/headers/notblank").header("blank-header","")).andExpect(status().isBadRequest());
        mockMvc.perform(get("/validation/headers/notblank")).andExpect(status().isBadRequest());
    }
}
