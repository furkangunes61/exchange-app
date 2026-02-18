package com.furkangunes.exchangeapp.service.impl;

import com.furkangunes.exchangeapp.client.ExchangeApiClient;
import com.furkangunes.exchangeapp.dto.ConversionResponse;
import com.furkangunes.exchangeapp.dto.ExchangeRateResponse;
import com.furkangunes.exchangeapp.exception.CurrencyNotFoundException;
import com.furkangunes.exchangeapp.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeApiClient  exchangeApiClient;

    @Override
    public ConversionResponse convert(String from, String to, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Miktar 0'dan büyük olmalıdır!");
        }

        ExchangeRateResponse rateData = exchangeApiClient.fetchRates(from);

        Double rate = rateData.getRates().get(to.toUpperCase());
        if (rate == null) {
            throw new CurrencyNotFoundException(to + "para birimi bulunamadı!");
        }

        double result = amount * rate;

        return ConversionResponse.builder()
                .from(from.toUpperCase())
                .to(to.toUpperCase())
                .amount(amount)
                .rate(rate)
                .result(Math.round(result * 100.0) / 100)
                .build();
    }

    @Override
    public Map<String, Double> getRates(String baseCurrency) {
        ExchangeRateResponse rateData = exchangeApiClient.fetchRates(baseCurrency);
        return rateData.getRates();
    }

    @Override
    public Set<String> getSupportedCurrencies() {
        ExchangeRateResponse rateData = exchangeApiClient.fetchRates("USD");
        return rateData.getRates().keySet();
    }
}
