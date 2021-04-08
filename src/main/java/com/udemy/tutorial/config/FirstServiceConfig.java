package com.udemy.tutorial.config;

import com.udemy.tutorial.services.ManualService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstServiceConfig {

    // By default, the name that Spring gives the bean is the name of the method that you are using. So in this example
    // It'd name it manualService as that is the name of the method.
    @Bean
    public ManualService manualService() {
        return new ManualService();
    }
}
