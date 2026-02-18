package com.furkangunes.exchangeapp.service;

import com.furkangunes.exchangeapp.dto.ConversionResponse;

import java.util.Map;
import java.util.Set;

public interface ExchangeService {

    ConversionResponse convert(String from, String to, double amount);

    Map<String, Double> getRates(String baseCurrency);

    Set<String> getSupportedCurrencies();

}
