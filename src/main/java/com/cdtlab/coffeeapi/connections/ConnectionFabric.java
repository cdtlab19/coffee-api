package com.cdtlab.coffeeapi.connections;


import java.lang.reflect.InvocationTargetException;

import com.cdtlab.coffeeapi.identity.Identity;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;



@NoArgsConstructor
@Component
@Scope("prototype")

public class ConnectionFabric {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private  HFClient client;

    public void initializesConnection() {
        CryptoSuite cryptoSuite;

        try {
            cryptoSuite = CryptoSuite.Factory.getCryptoSuite();
            LOGGER.info("Get CryptoSuite");

            client = HFClient.createNewInstance();
            client.setCryptoSuite(cryptoSuite);
            LOGGER.info("Use CryptoSuite");
            LOGGER.info("Initializes HFClient");
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | CryptoException
                | InvalidArgumentException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            LOGGER.error("Error initialize HFCLient");
        }

    }

    public HFClient getConnection() {
        LOGGER.info("Return client {}", client.getUserContext().getName());
        return client;
    }

    public void setContext(Identity identity) {
        try {
            client.setUserContext(identity);
            LOGGER.info("Change context client to {}", identity.getAffiliation());
        } catch (InvalidArgumentException e) {  e.printStackTrace();  }
    }
}
