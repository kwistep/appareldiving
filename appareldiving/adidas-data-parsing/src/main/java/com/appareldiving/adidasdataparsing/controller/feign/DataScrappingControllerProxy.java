package com.appareldiving.adidasdataparsing.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "adidas-data-scraping")
public interface DataScrappingControllerProxy {

    @GetMapping(path = "/adidas/{quantity}")
    List<String> collectAndHandOnProductLinks(@PathVariable int quantity);

}
