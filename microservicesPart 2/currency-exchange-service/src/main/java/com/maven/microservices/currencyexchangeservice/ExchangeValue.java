package com.maven.microservices.currencyexchangeservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
//http://localhost:8000/h2-console
//verify that jdbc:h2:mem:testdb
public class ExchangeValue {

    @Id
    private long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;
    private BigDecimal convertionMultiple;
    private int port;


    public ExchangeValue() {
    }

    public ExchangeValue(long id, String from, String to, BigDecimal convertionMultiple, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.convertionMultiple = convertionMultiple;
        this.port = port;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConvertionMultiple() {
        return convertionMultiple;
    }

    public void setConvertionMultiple(BigDecimal convertionMultiple) {
        this.convertionMultiple = convertionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

