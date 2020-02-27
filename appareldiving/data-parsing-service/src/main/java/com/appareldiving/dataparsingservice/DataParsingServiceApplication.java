package com.appareldiving.dataparsingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DataParsingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataParsingServiceApplication.class, args);
    }

}
