package com.appareldiving.adidasdatascraping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.appareldiving.adidasdatascraping")
@EnableEurekaClient
public class AdidasDataScrapingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdidasDataScrapingApplication.class, args);
    }

}
