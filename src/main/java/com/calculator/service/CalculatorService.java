package com.calculator.service;

import com.calculator.model.CalculatedResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class CalculatorService {
    public CalculatedResponse add(List<BigDecimal> numbers) {
        Optional<BigDecimal> optionalResult = numbers.stream().reduce(BigDecimal::add);
        return CalculatedResponse.builder().result(optionalResult.orElse(BigDecimal.ZERO)).build();
    }

    public CalculatedResponse subtract(List<BigDecimal> numbers) {
        Optional<BigDecimal> optionalResult = numbers.stream().reduce(BigDecimal::subtract);
        return CalculatedResponse.builder().result(optionalResult.orElse(BigDecimal.ZERO)).build();
    }

    public CalculatedResponse multiply(List<BigDecimal> numbers) {
        Optional<BigDecimal> optionalResult = numbers.stream().reduce(BigDecimal::multiply);
        return CalculatedResponse.builder().result(optionalResult.orElse(BigDecimal.ZERO)).build();
    }

    public CalculatedResponse divide(List<BigDecimal> numbers) {
        if (numbers.size() != 2) return CalculatedResponse.builder().result(BigDecimal.ZERO).build();
        Optional<BigDecimal> optionalResult = numbers.stream().reduce(BigDecimal::divide);
        return CalculatedResponse.builder().result(optionalResult.orElse(BigDecimal.ZERO)).build();
    }

}
