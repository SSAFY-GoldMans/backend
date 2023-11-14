package com.goldmen.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FindMyHomeWithSubway {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application,application-batch,application-core");
        SpringApplication.run(FindMyHomeWithSubway.class);
    }
}
