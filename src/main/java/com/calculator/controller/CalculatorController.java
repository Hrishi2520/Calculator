package com.calculator.controller;

import com.calculator.model.CalculatedResponse;
import com.calculator.model.CalculatorRequest;
import com.calculator.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A simple arithmetic calculator supporting addition, subtraction, multiplication, and division for multiple numbers.
 */
@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService service;

    @PostMapping("/addition")
    public ResponseEntity<CalculatedResponse> add(@Valid @RequestBody CalculatorRequest request) {
        CalculatedResponse calculatedResponse = service.add(request.getNumbers());
        return ResponseEntity.status(HttpStatus.OK).body(calculatedResponse);
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculatedResponse> subtract(@Valid @RequestBody CalculatorRequest request) {
        CalculatedResponse calculatedResponse = service.subtract(request.getNumbers());
        return ResponseEntity.status(HttpStatus.OK).body(calculatedResponse);
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculatedResponse> multiply(@Valid @RequestBody CalculatorRequest request) {
        CalculatedResponse calculatedResponse = service.multiply(request.getNumbers());
        return ResponseEntity.status(HttpStatus.OK).body(calculatedResponse);
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculatedResponse> divide(@Valid @RequestBody CalculatorRequest request) {
        CalculatedResponse calculatedResponse = service.divide(request.getNumbers());
        return ResponseEntity.status(HttpStatus.OK).body(calculatedResponse);
    }

}