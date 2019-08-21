package com.adidas.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@ComponentScan(basePackages = "com.adidas.products")
@EnableJpaRepositories(basePackages = "com.adidas.products")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
