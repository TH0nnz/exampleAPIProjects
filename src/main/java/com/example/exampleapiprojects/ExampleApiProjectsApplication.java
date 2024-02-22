package com.example.exampleapiprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExampleApiProjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApiProjectsApplication.class, args);
    }

}
