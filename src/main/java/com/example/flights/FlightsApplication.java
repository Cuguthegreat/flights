package com.example.flights;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightsApplication {

    public static void main(String[] args) {


        var myApp = SpringApplication.run(FlightsApplication.class, args);

        var dummy = myApp.getBean("flightsApplication");

    }

}
