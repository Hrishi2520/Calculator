package com.calculator.service;

import com.calculator.model.CalculatedResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


/**
 * Calculator Service has operations like add, subtract, multiply and divide.
 */
@Service
public class CalculatorService {
    /**
     * Performs addition operation on the given List of BigInteger elements.
     */
    public CalculatedResponse add(List<BigDecimal> numbers) {
        if (numbers == null)
            throw new IllegalArgumentException("At least two number is required for Addition Operation.");

        Optional<BigDecimal> optionalResult = numbers.stream().reduce(BigDecimal::add);
        return CalculatedResponse.builder().result(optionalResult.orElse(BigDecimal.ZERO)).build();
    }

    /**
     * Performs subtract operation on the given List of BigInteger elements.
     */
    public CalculatedResponse subtract(List<BigDecimal> numbers) {
        if (numbers == null)
            throw new IllegalArgumentException("At least two number is required for Subtraction Operation.");

        Optional<BigDecimal> optionalResult = numbers.stream().reduce(BigDecimal::subtract);
        return CalculatedResponse.builder().result(optionalResult.orElse(BigDecimal.ZERO)).build();
    }

    /**
     * Performs multiply operation on the given List of BigInteger elements.
     */
    public CalculatedResponse multiply(List<BigDecimal> numbers) {
        if (numbers == null)
            throw new IllegalArgumentException("At least two number is required for Multiply Operation.");

        Optional<BigDecimal> optionalResult = numbers.stream().reduce(BigDecimal::multiply);
        return CalculatedResponse.builder().result(optionalResult.orElse(BigDecimal.ZERO)).build();
    }

    /**
     * Performs divide operation on the given List of BigInteger elements.
     */
    public CalculatedResponse divide(List<BigDecimal> numbers) {
        BigDecimal divisor = numbers.get(1);
        if (divisor.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("Cannot perform division operation with zero");
        } else if (numbers.size() != 2) {
            return CalculatedResponse.builder().result(BigDecimal.ZERO).build();
        }

        Optional<BigDecimal> optionalResult = numbers.stream().reduce(BigDecimal::divide);
        return CalculatedResponse.builder().result(optionalResult.orElse(BigDecimal.ZERO)).build();
    }

}
