package com.maven.microservices.currencyconvertionservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConvertionController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertionBean convertCurrency(@PathVariable String from, @PathVariable String to
    , @PathVariable BigDecimal quantity){


        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);


        ResponseEntity<CurrencyConvertionBean> currencyConvertionBeanResponseEntity =
                new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR",
                CurrencyConvertionBean.class,uriVariables);


        CurrencyConvertionBean response = currencyConvertionBeanResponseEntity.getBody();


        return new CurrencyConvertionBean(response.getId(),from,to,response.getConvertionMultiple(),
                quantity,quantity.multiply(response.getConvertionMultiple()),response.getPort());
    }
}
