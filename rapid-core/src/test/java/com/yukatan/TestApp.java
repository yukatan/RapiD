package com.yukatan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.yukatan.rapid.config")
@EnableConfigurationProperties
public class TestApp {
}
