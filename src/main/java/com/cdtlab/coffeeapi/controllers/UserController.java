package com.cdtlab.coffeeapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(value="/api/users")
public class UserController {

    @RequestMapping(value="/", method=RequestMethod.POST)
    public createUser() {

    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public updateUser() {

    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public deleteUser() {

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public getUser() {

    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public allUsers() {

    }

    
}