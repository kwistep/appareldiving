package com.appareldiving.dataparsingadidasservice.controller.feign;

import com.appareldiving.dataparsingadidasservice.dto.Offer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("database-service")
public interface DatabaseServiceProxy {

    @PutMapping("/save")
    public void saveData(@RequestBody List<Offer> offers);
}
