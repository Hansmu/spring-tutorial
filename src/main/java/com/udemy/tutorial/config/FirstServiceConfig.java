package com.udemy.tutorial.config;

import com.udemy.tutorial.services.ManualService;
import com.udemy.tutorial.services.SecondService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

// PropertySource is not needed if you're using spring boot. You can utilize application.properties, which is the default from which
// Spring boot searches for its properties.
@PropertySource("classpath:some-custom-properties-file.properties") // Define a separate property file to check. Have to be loaded up into the context for use.
@Configuration
public class FirstServiceConfig {

    @Bean
    public PropertyInjectionExample propertyInjectionExample(
            @Value("${doggoMarker.username}") String username,
            @Value("${doggoMarker.password}") String password,
            @Value("${doggoMarker.jdbcUrl}") String jdbcUrl,
            @Value("${someValue.initialValue}") String someInitialValue
    ) {
        System.out.println("SOME INITIAL VALUE BEING PRINTED HERE: " + someInitialValue);
        PropertyInjectionExample propertyInjectionExample = new PropertyInjectionExample();

        propertyInjectionExample.setUsername(username);
        propertyInjectionExample.setPassword(password);
        propertyInjectionExample.setJdbcUrl(jdbcUrl);

        return propertyInjectionExample;
    }

    @Bean
    public PropertyInjectionExample propertyInjectionExampleBoot(
            @Value("${commonCustomProperties.doggoMarker.username}") String username,
            @Value("${commonCustomProperties.doggoMarker.password}") String password,
            @Value("${commonCustomProperties.doggoMarker.jdbcUrl}") String jdbcUrl
    ) {
        PropertyInjectionExample propertyInjectionExample = new PropertyInjectionExample();

        propertyInjectionExample.setUsername(username);
        propertyInjectionExample.setPassword(password);
        propertyInjectionExample.setJdbcUrl(jdbcUrl);

        return propertyInjectionExample;
    }

    // By default, the name that Spring gives the bean is the name of the method that you are using. So in this example
    // It'd name it manualService as that is the name of the method.
    @Bean
    public ManualService manualService() {
        return new ManualService();
    }

    // Can declare @Primary on either the class or when constructing the bean.
    @Primary
//    @Profile({"EN"}) /* Can also specify the profile on the constructor method */
    @Bean("secondService") // You can override the default name that it'd give the bean via the method name, by using a property on the bean annotation.
    public SecondService secondService(ManualService manualService) { // In order to do dependency injection, you can take the required beans
        // in as parameters, and the available beans to Spring will be added.
        return new SecondService(manualService);
    }
}
