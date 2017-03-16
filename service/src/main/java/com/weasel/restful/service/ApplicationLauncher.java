package com.weasel.restful.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dylan
 * @date 2016/7/20.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ApplicationLauncher {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationLauncher.class,args);
    }
}
