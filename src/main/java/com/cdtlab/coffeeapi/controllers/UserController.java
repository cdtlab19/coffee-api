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

		@Autowired
    private UserService service;

	@RequestMapping(value="/", method=RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserDTO user, HttpServletRequest request) {
		try {
        	SessionConnection sessionConnection = (SessionConnection) request.getSession()
    				.getAttribute("SESSION_CONNECTION");

    		if (sessionConnection == null) {
    			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    		}
	     return new ResponseEntity<>(service.CreateUser(user), HttpStatus.OK);
		} catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>((List<Response>) e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO user, HttpServletRequest request) {) {
    	public ResponseEntity<?> deleteUser(@PathVariable String id, HttpServletRequest request) {
        	try {
            	SessionConnection sessionConnection = (SessionConnection) request.getSession()
        				.getAttribute("SESSION_CONNECTION");

        		if (sessionConnection == null) {
        			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        		}
    	     return new ResponseEntity<>(service.UpdateUser(user), HttpStatus.OK);
    		} catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return new ResponseEntity<>((List<Response>) e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String id, HttpServletRequest request) {
    	try {
        	SessionConnection sessionConnection = (SessionConnection) request.getSession()
    				.getAttribute("SESSION_CONNECTION");

    		if (sessionConnection == null) {
    			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    		}
	     return new ResponseEntity<>(service.DeleteUser(id), HttpStatus.OK);
		} catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>((List<Response>) e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id, HttpServletRequest request) {
    	public ResponseEntity<?> deleteUser(@PathVariable String id, HttpServletRequest request) {
        	try {
            	SessionConnection sessionConnection = (SessionConnection) request.getSession()
        				.getAttribute("SESSION_CONNECTION");

        		if (sessionConnection == null) {
        			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        		}
    	     return new ResponseEntity<>(service.GetUser(id), HttpStatus.OK);
    		} catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return new ResponseEntity<>((List<Response>) e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping(value="/")
    public ResponseEntity<?> allUsers(HttpServletRequest request) {
    	public ResponseEntity<?> deleteUser(@PathVariable String id, HttpServletRequest request) {
        	try {
            	SessionConnection sessionConnection = (SessionConnection) request.getSession()
        				.getAttribute("SESSION_CONNECTION");

        		if (sessionConnection == null) {
        			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        		}
    	     return new ResponseEntity<>(service.AllUser(id), HttpStatus.OK);
    		} catch (InvalidArgumentException | ProposalException | InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return new ResponseEntity<>((List<Response>) e, HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    
}