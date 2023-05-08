package com.example.test.service;

import com.example.test.dto.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO savedNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteById(UUID beerId);
}
