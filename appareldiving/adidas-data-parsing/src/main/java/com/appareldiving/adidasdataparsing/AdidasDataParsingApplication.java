package com.appareldiving.adidasdataparsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@EnableFeignClients("com.appareldiving.adidasdataparsing")
@EnableEurekaClient
@EnableHystrix
public class AdidasDataParsingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdidasDataParsingApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplateReadTimeout(RestTemplateBuilder builder) {
        return builder
                .setReadTimeout(Duration.ofSeconds(15)) //15 seconds
                .build();
    }

}
