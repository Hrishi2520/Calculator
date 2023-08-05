package com.controller;

import com.pojo.RequestedData;
import com.pojo.ResponseBody;
import com.service.OperationService;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebController {
    @Autowired
    private OperationService service;
    @GetMapping("/add")
    public ResponseBody addition(@NotBlank @RequestBody RequestedData data) {
        return service.addition(data);
    }
    @GetMapping("/mul")
    public ResponseBody multiply(@NotBlank @RequestBody RequestedData data) {
        return service.multiply(data);
    }
    @GetMapping("/div")
    public ResponseBody divide(@NotBlank @RequestBody RequestedData data) {
        return service.divide(data);
    }
    @GetMapping("/sub")
    public ResponseBody subtract(@NotBlank @RequestBody RequestedData data) {
        return service.subtraction(data);
    }
}