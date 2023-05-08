package com.example.test.service.v2;

import com.example.test.dto.BeerDTO;
import com.example.test.dto.v2.BeerDTOV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDTO savedNewBeer(BeerDTOV2 beerDTO) {
        return null;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 beerDTO) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
