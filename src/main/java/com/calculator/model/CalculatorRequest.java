package com.calculator.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CalculatorRequest {
    List<BigDecimal> numbers;
}

