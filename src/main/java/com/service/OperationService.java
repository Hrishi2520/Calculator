package com.service;

import com.pojo.RequestedData;
import com.pojo.ResponseBody;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    public ResponseBody addition(RequestedData data) {
        return ResponseBody.builder().output(data.getInt1() - data.getInt2()).build();
    }

    public ResponseBody multiply(RequestedData data) {
        return ResponseBody.builder().output(data.getInt1() - data.getInt2()).build();
    }

    public ResponseBody divide(RequestedData data) {
        return ResponseBody.builder().output(data.getInt1() - data.getInt2()).build();
    }

    public ResponseBody subtraction (RequestedData data) {
        return ResponseBody.builder().output(data.getInt1() - data.getInt2()).build();
    }
}
