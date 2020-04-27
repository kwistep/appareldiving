package com.appareldiving.adidasdataparsing.service;

import com.appareldiving.adidasdataparsing.controller.feign.DataScrappingControllerProxy;
import com.appareldiving.adidasdataparsing.exception.ListNullException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ResponseService implements IResponseService{

    private static final String LINKS = "links";
    private static final String SEPARATOR = ",http";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataScrappingControllerProxy proxy;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public List<String> getResponse(String parser, int quantity)
    {
        logger.info("Number of links was required: [" + quantity + "].");

        List<String> links = proxy.collectAndHandOnProductLinks(parser, quantity);

        logger.info("Number of links was collected: [" + links.size() + "].");

        redisTemplate.opsForList().rightPushAll(LINKS, links);

        logger.info("Links were saved.");

        return links;
    }

    public List<String> getStoredLinks() throws ListNullException {
        Long size = redisTemplate.opsForList().size(LINKS);
        if(Objects.isNull(size) )
            throw new ListNullException(LINKS);

        return parseStoredValue(Objects.requireNonNull(redisTemplate.opsForList().range(LINKS, 0, size-1)));
    }

    /**
     * Input: values of "list" key in Redis
     * Output: parsed values into single string to represent plain links
     *
     * @param storedValue list of values from Redis
     * @return list of links
     */

    private List<String> parseStoredValue(List<Object> storedValue)
    {
        List<String> storedLinks = new ArrayList<>();

        for( Object x : storedValue )
        {
            String[] split = String.valueOf(x).split(SEPARATOR);

            for( int i = 0; i < split.length; i++)
            {
                if(!split[i].startsWith("http"))
                    split[i] = "http" + split[i];
            }

            storedLinks.addAll(Arrays.asList(split));
        }

        return storedLinks;
    }

    public boolean removeStoredLinks() {
        Long size = redisTemplate.opsForList().size(LINKS);
        if( Objects.nonNull(size) )
        {
            return redisTemplate.delete(LINKS);
        }
        else
        {
            return false;
        }
    }


}
