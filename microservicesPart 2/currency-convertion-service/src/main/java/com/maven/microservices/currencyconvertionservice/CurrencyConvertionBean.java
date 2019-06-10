package com.maven.microservices.currencyconvertionservice;


import java.math.BigDecimal;

public class CurrencyConvertionBean {

    private Long id;
    private String from;
    private String to;
    private BigDecimal convertionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private int port;


    public CurrencyConvertionBean() {
    }

    public CurrencyConvertionBean(Long id, String from, String to, BigDecimal convertionMultiple, BigDecimal quantity, BigDecimal totalCalculatedAmount, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.convertionMultiple = convertionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.port = port;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
