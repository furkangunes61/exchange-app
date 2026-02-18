package com.furkangunes.exchangeapp.controller;

import com.furkangunes.exchangeapp.dto.ConversionResponse;
import com.furkangunes.exchangeapp.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/convert")
    public ResponseEntity<ConversionResponse> convert(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        return ResponseEntity.ok(exchangeService.convert(from, to, amount));
    }

    @GetMapping("/rates")
    public ResponseEntity<Map<String, Double>> getRates(@RequestParam String base) {
        return ResponseEntity.ok(exchangeService.getRates(base));
    }

    @GetMapping("/currencies")
    public ResponseEntity<Set<String>> getSupportedCurrencies() {
        return ResponseEntity.ok(exchangeService.getSupportedCurrencies());
    }
}
