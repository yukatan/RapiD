package com.yukatan.test.rapid;

import com.yukatan.TestApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.yukatan.rapid.core.descriptor.ApiDescriptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("testdescriptors")
@SpringApplicationConfiguration(classes = TestApp.class)
@WebAppConfiguration
public class DescriptorsTest {

    public static final String TEST_PATH = "/org/yukatan/test";

    @Autowired
    private ApiDescriptor apiDescriptor;


    @Test
    public void testEnpointPath() throws Exception {

        assertNotNull(apiDescriptor);
        assertEquals(TEST_PATH,apiDescriptor.getEndpoints().get(0).getPath());
    }


}
