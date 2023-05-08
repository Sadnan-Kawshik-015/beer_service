package com.example.test.service.v2;

import com.example.test.dto.BeerDTO;
import com.example.test.dto.v2.BeerDTOV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDTOV2 getBeerById(UUID beerId);

    BeerDTO savedNewBeer(BeerDTOV2 beerDTO);

    void updateBeer(UUID beerId, BeerDTOV2 beerDTO);

    void deleteById(UUID beerId);
}
