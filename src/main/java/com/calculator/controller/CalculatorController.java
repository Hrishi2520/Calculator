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
public class CalculatorController implements ApplicationRunner {

    private static final Logger logger = LogManager.getLogger(CalculatorController.class);

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
    }
}