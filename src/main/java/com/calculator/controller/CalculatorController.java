package com.calculator.controller;

import com.calculator.CalculatorApplication;
import com.calculator.model.CalculatedResponse;
import com.calculator.model.CalculatorRequest;
import com.calculator.service.CalculatorService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A simple arithmetic calculator supporting addition, subtraction, multiplication, and division for multiple numbers.
 */
@RestController
public class CalculatorController {

    private static final Logger logger = LogManager.getLogger(CalculatorController.class);

    @Autowired
    private CalculatorService service;

    @PostMapping("/addition")
    public ResponseEntity<CalculatedResponse> add(@Valid @RequestBody CalculatorRequest request) {
        logger.info("Received Numbers for Addition...");
        CalculatedResponse calculatedResponse = service.add(request.getNumbers());
        logger.info("Calculated numbers of addition: "+ calculatedResponse);
        return ResponseEntity.status(HttpStatus.OK).body(calculatedResponse);
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculatedResponse> subtract(@Valid @RequestBody CalculatorRequest request) {
        logger.info("Received Numbers for subtract...");
        CalculatedResponse calculatedResponse = service.subtract(request.getNumbers());
        logger.info("Calculated numbers of subtract: "+ calculatedResponse);
        return ResponseEntity.status(HttpStatus.OK).body(calculatedResponse);
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculatedResponse> multiply(@Valid @RequestBody CalculatorRequest request) {
        logger.info("Received Numbers for multiply...");
        CalculatedResponse calculatedResponse = service.multiply(request.getNumbers());
        logger.info("Calculated numbers of multiply: "+ calculatedResponse);
        return ResponseEntity.status(HttpStatus.OK).body(calculatedResponse);
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculatedResponse> divide(@Valid @RequestBody CalculatorRequest request) {
        logger.info("Received Numbers for divide...");
        CalculatedResponse calculatedResponse = service.divide(request.getNumbers());
        logger.info("Calculated numbers of divide: "+ calculatedResponse);
        return ResponseEntity.status(HttpStatus.OK).body(calculatedResponse);
    }
}