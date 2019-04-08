package com.cdtlab.coffeeapi.controllers;

import com.cdtlab.coffeeapi.connections.SessionConnection;
import com.cdtlab.coffeeapi.dto.IdentityDTO;
import com.cdtlab.coffeeapi.identity.Identity;
import com.cdtlab.coffeeapi.services.IdentityServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.NetworkConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api/wallet")
@Api(value = "Title", description = "description")
public class WalletController {

    @Autowired //auto instatiation
    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    private IdentityServices service;

    @ApiOperation(value = "Descrição")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Sucesso"),
            }
    )
    @PostMapping("/identity")
    public ResponseEntity<String> verifyIdentity(@RequestBody IdentityDTO user, HttpServletRequest request)
            throws InvalidArgumentException, NetworkConfigurationException, IOException, ClassNotFoundException {
        try {
            SessionConnection sessionConnection = (SessionConnection) request.getSession().getAttribute("SESSION_CONNECTION");

            if (sessionConnection == null){
                sessionConnection = new SessionConnection();
                beanFactory.autowireBean(sessionConnection);
            }
            service.checkIdentity(user.getIdentity());
            Identity identity = service.getIdentity();

            sessionConnection.getConnectionFabric().initializesConnection();
            sessionConnection.getConnectionFabric().setContext(identity);

            try {
                sessionConnection.getNetworkFabric().initializate(sessionConnection.getConnectionFabric().getConnection(),
                        identity.getAffiliation());
            } catch (InvalidArgumentException | NetworkConfigurationException e) {  e.printStackTrace();  }

            request.getSession().setAttribute("SESSION_CONNECTION", sessionConnection);


            return new ResponseEntity<>(sessionConnection.getConnectionFabric().getConnection().getUserContext().getName(), HttpStatus.OK);


        } catch (IOException e){
            return new ResponseEntity<>((MultiValueMap<String, String>) e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
