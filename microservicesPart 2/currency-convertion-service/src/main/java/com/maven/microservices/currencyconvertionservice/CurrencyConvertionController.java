package com.maven.microservices.currencyconvertionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConvertionController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Resource
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to
            , @PathVariable BigDecimal quantity){

        CurrencyConvertionBean response = proxy.retrieveExchangeValue(from,to);

        logger.info("{}",response);
        return new CurrencyConvertionBean(response.getId(),from,to,response.getConvertionMultiple(),
                quantity,quantity.multiply(response.getConvertionMultiple()),response.getPort());
    }

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
