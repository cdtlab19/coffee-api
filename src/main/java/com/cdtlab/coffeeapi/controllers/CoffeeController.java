package com.cdtlab.coffeeapi.controllers;

import javax.servlet.http.HttpServlet;

import com.cdtlab.coffeeapi.dto.CoffeeDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/api/coffees")
@Api(value = "title", description = "description")
public class CoffeeController {

    @ApiOperation(value = "Descrição")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Sucesso"),
            }
    )

    @PostMapping(value="/")
    public ResponseEntity<?> CreateCoffee(@RequestBody CoffeeDTO coffee, HttpServlet request) {
        return ResponseEntity.ok().body("topper da balada");
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<?> UpdateCoffee(@RequestBody CoffeeDTO coffee) {
        return null;
    }

    @DeleteMapping(value="/{id]")
    public ResponseEntity<?> DeleteCoffee(@RequestBody CoffeeDTO coffee) {
        return null;
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<?> GetCoffee(@RequestBody CoffeeDTO coffee) {
        return null;
    }
    
    @GetMapping(value="/")
    public ResponseEntity<?> AllCoffee() {
        return null;
    }

    @PutMapping(value="/{id}/use/{useId}")
    public ResponseEntity<?> UserCoffee(@RequestBody CoffeeDTO coffee) {
        return null;
    }

}