package com.udemy.tutorial;

import com.udemy.tutorial.config.PropertyInjectionExample;
import com.udemy.tutorial.services.FirstService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// When defining component scan, then you have to declare the default base package as well. It overrides the default behavior, so in
// order to keep the default, you have to specify it additionally.
@ComponentScan(basePackages = {"com.udemy.something", "com.udemy.tutorial"})
@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(TutorialApplication.class, args);

		FirstService firstService = run.getBean("firstService", FirstService.class);
		System.out.println(firstService.getHello());

		PropertyInjectionExample propertyInjectionExample = run.getBean("propertyInjectionExample", PropertyInjectionExample.class);
		System.out.println(propertyInjectionExample.getUsername());

		PropertyInjectionExample propertyInjectionExampleBoot = run.getBean("propertyInjectionExampleBoot", PropertyInjectionExample.class);
		System.out.println(propertyInjectionExampleBoot.getUsername());
	}

}
