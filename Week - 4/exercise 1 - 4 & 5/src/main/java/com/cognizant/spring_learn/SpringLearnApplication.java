package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);

        SpringLearnApplication app = new SpringLearnApplication();
        app.displayCountryScope();

        LOGGER.info("END");
    }

    public void displayCountryScope() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country singleton1 = context.getBean("countrySingleton", Country.class);
        Country singleton2 = context.getBean("countrySingleton", Country.class);

        Country prototype1 = context.getBean("countryPrototype", Country.class);
        Country prototype2 = context.getBean("countryPrototype", Country.class);

        LOGGER.debug("Singleton Bean 1: {}", singleton1);
        LOGGER.debug("Singleton Bean 2: {}", singleton2);
        LOGGER.debug("Prototype Bean 1: {}", prototype1);
        LOGGER.debug("Prototype Bean 2: {}", prototype2);

        LOGGER.info("END");
    }
}
