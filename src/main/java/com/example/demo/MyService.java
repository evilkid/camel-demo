package com.example.demo;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void myMethod(Exchange exchange) {
        exchange.getIn().setBody("test1");
    }
}