package com.example.flights.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {
    String city;
    String country;
}
