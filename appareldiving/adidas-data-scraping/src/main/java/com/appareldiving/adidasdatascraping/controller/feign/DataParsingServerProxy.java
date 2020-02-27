package com.appareldiving.adidasdatascraping.controller.feign;

import com.appareldiving.adidasdatascraping.dto.RequestData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("data-parsing-service")
public interface DataParsingServerProxy{

    @PostMapping("/request")
    public void getData(@RequestBody RequestData requestData);


}
