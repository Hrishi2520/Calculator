package com.calculator.controller;

import com.calculator.model.CalculatedResponse;
import com.calculator.model.CalculatorRequest;
import com.calculator.service.CalculatorService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService service;

    @PostMapping("/addition")
    public CalculatedResponse add(@NotBlank @RequestBody CalculatorRequest request) {
        return service.add(request.getNumbers());
    }

    @PostMapping("/subtract")
    public CalculatedResponse subtract(@NotBlank @RequestBody CalculatorRequest request) {
        return service.subtract(request.getNumbers());
    }

    @PostMapping("/multiply")
    public CalculatedResponse multiply(@NotBlank @RequestBody CalculatorRequest request) {
        return service.multiply(request.getNumbers());
    }

    @PostMapping("/divide")
    public CalculatedResponse divide(@NotBlank @RequestBody CalculatorRequest request) {
        return service.divide(request.getNumbers());
    }

}