package com.appareldiving.dataretriever.controller.feign.scrapping;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "adidas-data-scraping")
public interface DataScrappingAdidasControllerScrappingProxy {

    @GetMapping(path = "/{parser}/{quantity}")
    List<String> collectAndHandOnProductLinks(@PathVariable String parser, @PathVariable int quantity);

}
