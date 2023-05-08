package com.example.test.controller;

import com.example.test.dto.BeerDTO;
import com.example.test.service.BeerService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;


    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beer_id}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable(name = "beer_id")  UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK );

    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDTO beerDTO)
    {
        BeerDTO savedDTO = beerService.savedNewBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/api/v1/beer"+savedDTO.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{beer_id}")
    public ResponseEntity handleUpdate(@PathVariable(name = "beer_id")  UUID beerId,@Valid @RequestBody BeerDTO beerDTO)
    {
       beerService.updateBeer(beerId,beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{beer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//returns empty body
    public void deleteBeer(@PathVariable(name = "beer_id")  UUID beerId)
    {
        beerService.deleteById(beerId);
    }


}

