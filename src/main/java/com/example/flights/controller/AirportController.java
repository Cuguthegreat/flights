package com.example.flights.controller;

import java.util.List;

import com.example.flights.dto.AirportDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @GetMapping
    public List<AirportDto> getAirport() {
        return List.of(AirportDto.builder().build());
    }

}
