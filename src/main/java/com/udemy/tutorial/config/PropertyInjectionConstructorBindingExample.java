package com.udemy.tutorial.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("gotta-kebab.custom-inject")
public class PropertyInjectionConstructorBindingExample {
    private final String username;
    private final String password;
    private final String jdbcUrl;

    public PropertyInjectionConstructorBindingExample(String username, String password, String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
