# appareldiving

### Ports

| Application  | Port | 
| ------------- | ------------- | 
| DataScrapingService  | 8000..8009  |
| AdidasDataParsingService  | 8010..8019  |
| Eureka server  | 8761  |
| Zuul Getaway  | 8765  |
| Zipkin Tracing System  | 9411  |



### Dev checklist

| Feature  | AdidasParsingService | AdidasScrapingService |
| ------------- | ------------- | ------------- |
| Set up port  | [X]  | [X] |
| Set up app name  | [X]  | [X] |
| Eureka client  | [X]  | [X] |
| Zull | []  | [] |
| RabbitMQ  | [] | [] |
| Zipkin  | []  | [] |
| Hystrix  | []  | [] |
| Exception handling  | [] | [] |
| Swagger  | []  | [] |


ElasticSearch index :
PUT /appareldiving

json---

{
    "settings" : {
        "index" : {
            "number_of_shards" : 3, 
            "number_of_replicas" : 1 
        }
    },
    "mappings" : {
        "_doc" : {
            "properties" : {
                "productId" : { "type" : "text" },
                "price" : { "type" : "float" },
                "salesPrice" : { "type" : "float" },
                "color" : { "type" : "text" },
                "orderable" : { "type" : "boolean" },
                "productUrl" : { "type" : "text" },
                "productImages" : { "type" : "text" }
            }
        }
    }
}

----
