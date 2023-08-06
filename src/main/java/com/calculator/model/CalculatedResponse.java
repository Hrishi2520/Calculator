package com.calculator.model;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class CalculatedResponse {
    private BigDecimal result;
}