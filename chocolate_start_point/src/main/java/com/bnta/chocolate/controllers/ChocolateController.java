package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chocolate")
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

    //GET
    @GetMapping
    public ResponseEntity<Chocolate> getAllChocolates() {
        return new ResponseEntity(chocolateRepository.findAll(), HttpStatus.OK);
    }

    /*
    @GetMapping
    public ResponseEntity<Estate> getAllChocolatesAndCocoaPercentage(
            @RequestParam(required = false, name = "type") @PathVariable int cocoaPercentage) {
        if (cocoaPercentage >= 0) {
            return new ResponseEntity(chocolateRepository.findChocolateByCocoaPercentage(cocoaPercentage), HttpStatus.OK);
        }
        return new ResponseEntity(chocolateRepository.findAll(), HttpStatus.OK);
    }
     */

//    //QUERY
//    @GetMapping
//    public ResponseEntity<Chocolate> getChocolateByCocoaPercentage(@RequestParam(name = "type") int cocoaPercentage){
//        return new ResponseEntity(chocolateRepository.findChocolateByCocoaPercentage(cocoaPercentage), HttpStatus.OK);
//    }

    //SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable Long id) {
        return new ResponseEntity(chocolateRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping
    public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate newChocolate) {
        chocolateRepository.save(newChocolate);
        return new ResponseEntity<>(newChocolate, HttpStatus.CREATED);
    }

}

