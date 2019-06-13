package com.maven.microservices.currencyconvertionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// when no ribbon is present @FeignClient(name = "currency-exchange-service",url = "localhost:8000")
// sin zuul @FeignClient(name = "currency-exchange-service")
@FeignClient("netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    //sin zuul @GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConvertionBean retrieveExchangeValue(@PathVariable("from") String from , @PathVariable("to") String to);
}
