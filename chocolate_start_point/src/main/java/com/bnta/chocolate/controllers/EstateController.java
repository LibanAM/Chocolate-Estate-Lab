package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estate")
public class EstateController {

    @Autowired
    EstateRepository estateRepository;

    @GetMapping
    public ResponseEntity<Estate> getAllEstates(){
        return new ResponseEntity(estateRepository.findAll(), HttpStatus.OK);
    }
    /*
    // GET
    @GetMapping
    public ResponseEntity<Estate> getAllEstatesAndCocoaPercentage(@RequestParam(required = false, name = "type") int cocoaPercentage) {
        if (cocoaPercentage != null) {
            return new ResponseEntity(estateRepository.findChocolateByCocoaPercentage(cocoaPercentage), HttpStatus.OK);
        } else  {
            return new ResponseEntity(estateRepository.findAll(), HttpStatus.OK);
        }
    }
         */


//    @GetMapping
//    public ResponseEntity<Chocolate> getChocolateByCocoaPercentage(@RequestParam(name = "type") int cocoaPercentage){
//
//    }

    //SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Estate> getEstateById(@PathVariable Long id) {
        return new ResponseEntity(estateRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping
    public ResponseEntity<Estate> createEstate(@RequestBody Estate newEstate) {
        estateRepository.save(newEstate);
        return new ResponseEntity<>(newEstate, HttpStatus.CREATED);
    }
}
