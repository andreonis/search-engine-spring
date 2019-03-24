package com.searchengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //enabling 3 features in one go, like : @EnableAutoConfiguration , @ComponentScan , @Configuration
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
