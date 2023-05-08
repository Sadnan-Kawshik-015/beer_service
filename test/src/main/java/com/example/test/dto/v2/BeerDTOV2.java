package com.example.test.dto.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BeerDTOV2 {
    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private long upc;
}
