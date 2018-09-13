package com.example.demo;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleCamelRoute extends RouteBuilder {

    @Autowired
    private MyService myService;

    @Override
    public void configure() {
        rest()
                .get("hello")
                .to("direct:hello");

        from("direct:hello")
                .process(exchange -> myService.myMethod(exchange))
                .log(LoggingLevel.INFO, "Hello World")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
    }
}
