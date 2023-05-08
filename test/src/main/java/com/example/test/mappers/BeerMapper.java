package com.example.test.mappers;

import com.example.test.dto.BeerDTO;
import com.example.test.model.Beer;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDTO beerToBeerDTO(Beer beer);
    Beer beerDtoTobeer(BeerDTO beerDTO);
}
