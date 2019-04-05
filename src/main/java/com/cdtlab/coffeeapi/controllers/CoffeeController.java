package com.cdtlab.coffeeapi.controllers;

import javax.servlet.http.HttpServlet;

import com.cdtlab.coffeeapi.dto.CoffeeDTO;

import com.cdtlab.coffeeapi.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CoffeeService service;

    @RequestMapping(value="/", method=RequestMethod.POST)
    public ResponseEntity<?> createCoffee(@RequestBody CoffeeDTO coffee, HttpServlet request) {
        try {
            // session - falta implementar essa parte aqui.
            // Converts - inserir a parte de converter um DTO para um modelo de café, caso seja necessário.

            res = service.createCoffee(); //passando o café como parâmetro
            return ResponseEntity.().ok.body(); // passando algo tratado

        } catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
            return ResponseEntity();
        }
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateCoffee(@RequestBody CoffeeDTO coffee) {
        try {
            // session - falta implementar essa parte aqui.
            // Converts - inserir a parte de converter um DTO para um modelo de café, caso seja necessário.

            res = service.updateCoffee(); //passando o café como parâmetro
            return ResponseEntity.().ok.body(); // passando algo tratado

        } catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
            return ResponseEntity();
        }
    }

    @RequestMapping(value="/{id]", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteCoffee(@RequestBody CoffeeDTO coffee) {
        try {
            // session - falta implementar essa parte aqui.
            // Converts - inserir a parte de converter um DTO para um modelo de café, caso seja necessário.

            res = service.deleteCoffee(); //passando o id do café como parâmetro
            return ResponseEntity.().ok.body(); // passando algo tratado

        } catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
            return ResponseEntity();
        }
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> getCoffee(@RequestBody CoffeeDTO coffee) {
        try {
            // session - falta implementar essa parte aqui.
            // Converts - inserir a parte de converter um DTO para um modelo de café, caso seja necessário.

            res = service.getCoffee(); //passando o id café como parâmetro
            return ResponseEntity.().ok.body(); // passando algo tratado

        } catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
            return ResponseEntity();
        }
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> allCoffee() {
        try {
            // session - falta implementar essa parte aqui.
            // Converts - inserir a parte de converter um DTO para um modelo de café, caso seja necessário.

            res = service.allCoffee();
            return ResponseEntity.().ok.body(); // passando algo tratado

        } catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
            return ResponseEntity();
        }
    }
    
    @RequestMapping(value="/{id}/use/{useId}", method=RequestMethod.PUT)
    public ResponseEntity<?> userCoffee(@RequestBody CoffeeDTO coffee) {
        try {
            // session - falta implementar essa parte aqui.
            // Converts - inserir a parte de converter um DTO para um modelo de café, caso seja necessário.

            res = service.userCoffee();
            return ResponseEntity.().ok.body(); // passando algo tratado

        } catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
            return ResponseEntity();
        }
    }

}