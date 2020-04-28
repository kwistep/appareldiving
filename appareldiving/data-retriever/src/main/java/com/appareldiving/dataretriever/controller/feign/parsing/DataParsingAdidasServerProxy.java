package com.appareldiving.dataretriever.controller.feign.parsing;

import com.appareldiving.dataretriever.dto.RequestData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("data-parsing-adidas-service")
public interface DataParsingAdidasServerProxy {

    @PostMapping("/process")
    String processData(@RequestBody RequestData requestData);


}
