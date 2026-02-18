package com.furkangunes.exchangeapp.client;

import com.furkangunes.exchangeapp.dto.ExchangeRateResponse;
import com.furkangunes.exchangeapp.exception.CurrencyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ExchangeApiClient {

    @Value("${exchange.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public ExchangeRateResponse fetchRates(String baseCurrency) {
        String url = apiUrl + "/" + baseCurrency.toUpperCase();

        try {
            return restTemplate.getForObject(url, ExchangeRateResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new CurrencyNotFoundException(baseCurrency + " para birimi bulunamadı!");
        }
    }
}
