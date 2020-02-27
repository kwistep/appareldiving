package com.appareldiving.adidasdataparsing.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "adidas-data-scraping")
public interface DataScrappingControllerProxy {

    @GetMapping(path = "/adidas")
    List<String> collectAndHandOnProductLinks();

}
