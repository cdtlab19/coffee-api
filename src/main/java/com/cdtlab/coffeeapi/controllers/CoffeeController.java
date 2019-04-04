package com.cdtlab.coffeeapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/api/coffees")
public class CoffeeController {
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ResponseEntity<?> CreateCoffee(@RequestParam String param) {
        return new ResponseEntity<?>();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> UpdateCoffee(@RequestParam String param) {
        return new SomeData();
    }

    @RequestMapping(value="/{id]", method=RequestMethod.DELETE)
    public ResponseEntity<?> DeleteCoffee(@RequestParam String param) {
        return new SomeData();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> GetCoffee(@RequestParam String param) {
        return new ResponseEntity<?>();
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> AllCoffee() {
        return new ResponseEntity<?>();
    }
    
    @RequestMapping(value="/{id}/use/{useId}", method=RequestMethod.PUT)
    public ResponseEntity<?> UserCoffee(@RequestParam String param) {
        return new ResponseEntity<?>();
    }
    
}