package com.cdtlab.coffeeapi.controllers;

import javax.servlet.http.HttpServletRequest;

import com.cdtlab.coffeeapi.dto.UserDTO;
import com.controllers.AccountChainCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(value="/api/users")
public class UserController {

    // @Autowired
    // UserService service;

	@RequestMapping(value="/", method=RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserDTO user, HttpServletRequest request) {
	     AccountChainCode account = AccountConverts.toEntity(user);
	
	     account.setMethod("Create");
	     return new ResponseEntity<>(chaincodeServices.invoke(sessionConnection.getConnectionFabric().getConnection(), sessionConnection.getChannelFabric().getChannel(), account), HttpStatus.OK);

        
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO user, HttpServletRequest request) {) {
    		     
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String id, HttpServletRequest request) {
    	AccountChainCode account = AccountConverts.toEntity(user);
    	
	    account.setMethod("Delete");

	    return new ResponseEntity<>(chaincodeServices.invoke(sessionConnection.getConnectionFabric().getConnection(), sessionConnection.getChannelFabric().getChannel(), account), HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String id, HttpServletRequest request) {
    	AccountChainCode account = AccountConverts.toEntity(user);
    	
	    account.setMethod("GetByUser");

	    return new ResponseEntity<>(chaincodeServices.query(sessionConnection.getConnectionFabric().getConnection(), sessionConnection.getChannelFabric().getChannel(), account), HttpStatus.OK);
        
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> allUsers(HttpServletRequest request) {
    	AccountChainCode account = AccountConverts.toEntity(user);
    	
	    account.setMethod("GetAllUsers");

	    return new ResponseEntity<>(chaincodeServices.query(sessionConnection.getConnectionFabric().getConnection(), sessionConnection.getChannelFabric().getChannel(), account), HttpStatus.OK);
        

    }

    
}