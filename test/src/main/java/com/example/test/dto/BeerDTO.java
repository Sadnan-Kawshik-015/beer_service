package com.example.test.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerDTO {

    @Null
    private  UUID id;

    @NotBlank
    private String beerName;
    @NotBlank
    private String beerStyle;

    @Positive
    private long upc;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;
    
}
