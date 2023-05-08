package com.example.test.controller.v2;

import com.example.test.dto.BeerDTO;
import com.example.test.dto.v2.BeerDTOV2;
import com.example.test.service.v2.BeerServiceV2;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    private final BeerServiceV2 beerServicev2;

    public BeerControllerV2(BeerServiceV2 beerServicev2) {
        this.beerServicev2 = beerServicev2;
    }


    @GetMapping("/{beer_id}")
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable(name = "beer_id") UUID beerId)
    {
        return new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK );

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDTOV2 beerDTO)
    {
        BeerDTO savedDTO = beerServicev2.savedNewBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/api/v1/beer"+savedDTO.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{beer_id}")
    public ResponseEntity handleUpdate(@PathVariable(name = "beer_id")  UUID beerId,@RequestBody BeerDTOV2 beerDTO)
    {
        beerServicev2.updateBeer(beerId,beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{beer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//returns empty body
    public void deleteBeer(@PathVariable(name = "beer_id")  UUID beerId)
    {
        beerServicev2 .deleteById(beerId);
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e)
//    {
//        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//
//        e.getConstraintViolations().forEach();
//
//    }

}
