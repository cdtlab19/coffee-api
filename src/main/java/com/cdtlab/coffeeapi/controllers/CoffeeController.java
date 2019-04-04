package com.cdtlab.coffeeapi.controllers;

import javax.servlet.http.HttpServlet;

import com.cdtlab.coffeeapi.dto.CoffeeDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/api/coffees")
public class CoffeeController {
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ResponseEntity<?> CreateCoffee(@RequestBody CoffeeDTO coffee, HttpServlet request) {
        return new ResponseEntity<>();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> UpdateCoffee(@RequestBody CoffeeDTO coffee) {
        return new ResponseEntity<>();
    }

    @RequestMapping(value="/{id]", method=RequestMethod.DELETE)
    public ResponseEntity<?> DeleteCoffee(@RequestBody CoffeeDTO coffee) {
        return new ResponseEntity<>();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> GetCoffee(@RequestBody CoffeeDTO coffee) {
        return new ResponseEntity<>();
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> AllCoffee() {
        return new ResponseEntity<>();
    }
    
    @RequestMapping(value="/{id}/use/{useId}", method=RequestMethod.PUT)
    public ResponseEntity<?> UserCoffee(@RequestBody CoffeeDTO coffee) {
        return new ResponseEntity<>();
    }

}