package com.udemy.tutorial.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// With the @ConfigurationProperties injection, the properties have to be kebab cased, not camelCased.
@Configuration
@ConfigurationProperties("gotta-kebab.custom-inject") // Add the prefix for properties that should be bound. The suffix will be used for which to bind.
public class PropertyInjectionExampleBinding {
    private String username;
    private String password;
    private String jdbcUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
