package com.cdtlab.coffeeapi.controllers;

import javax.servlet.http.HttpServletRequest;

import com.cdtlab.coffeeapi.dto.UserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 */
@RestController
@RequestMapping(value="/api/users")
@Api(value = "title", description = "description")
public class UserController {

    // @Autowired
    // private UserService service;

    @ApiOperation(value = "Descrição")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Sucesso"),
            }
    )

    @PostMapping(value="/")
    public ResponseEntity<?> createUser(@RequestBody UserDTO user, HttpServletRequest request) {
        return null;
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO user, HttpServletRequest request) {
        return null;
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id, HttpServletRequest request) {
        return null;
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id, HttpServletRequest request) {
        return null;
    }

    @GetMapping(value="/")
    public ResponseEntity<?> allUsers(HttpServletRequest request) {
        return null;
    }

    
}