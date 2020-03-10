package com.appareldiving.dataconsolidationservice.controller.feign;

import com.appareldiving.dataconsolidationservice.entity.Offer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("database-service")
public interface DataControllerProxy {

    @PutMapping(path = "/save")
    public List<Offer> saveData(@RequestBody List<Offer> offers);

}
