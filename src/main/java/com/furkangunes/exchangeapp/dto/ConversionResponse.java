package com.furkangunes.exchangeapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConversionResponse {

    private String from;
    private String to;
    private double amount;
    private double rate;
    private double result;
}
