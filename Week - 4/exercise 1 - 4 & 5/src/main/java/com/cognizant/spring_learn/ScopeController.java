package com.cognizant.spring_learn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class ScopeController {

    @GetMapping("/scope")
    public String showScopeDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country singleton1 = context.getBean("countrySingleton", Country.class);
        Country singleton2 = context.getBean("countrySingleton", Country.class);

        Country prototype1 = context.getBean("countryPrototype", Country.class);
        Country prototype2 = context.getBean("countryPrototype", Country.class);

        StringBuilder output = new StringBuilder();
        output.append("Singleton Bean 1: ").append(singleton1).append("<br>");
        output.append("Singleton Bean 2: ").append(singleton2).append("<br>");
        output.append("Prototype Bean 1: ").append(prototype1).append("<br>");
        output.append("Prototype Bean 2: ").append(prototype2);

        return output.toString();
    }
}
