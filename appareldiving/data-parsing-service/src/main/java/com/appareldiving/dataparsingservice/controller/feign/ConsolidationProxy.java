package com.appareldiving.dataparsingservice.controller.feign;

import com.appareldiving.dataparsingservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("data-consolidation-service")
public interface ConsolidationProxy {

    @PostMapping("/save/{quantity}")
    public void saveProduct(@RequestBody Product product, @PathVariable int quantity);
}
