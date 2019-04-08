package com.cdtlab.coffeeapi.connections;

import java.io.IOException;

import javax.annotation.PreDestroy;

import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.NetworkConfig;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.NetworkConfigurationException;
import org.hyperledger.fabric.sdk.exception.TransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
@Scope("prototype")

public class ChannelFabricConnection {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    @PreDestroy
    public void clear() {
        LOGGER.info("Clear Channel Fabric");
        try {
            LOGGER.info("Channel initialized {}", channel.isInitialized());
            channel.shutdown(true);
        } catch (Exception e) {
            LOGGER.info("Empty channel");
        }
    }

    public void setChannel(HFClient client, NetworkConfig network, String channelName)
            throws InvalidArgumentException, TransactionException, NetworkConfigurationException, IOException {

        try {
            LOGGER.info("Channel initialized {}", channel.isInitialized());
            if (channel.isInitialized())
                channel.shutdown(true);
        } catch (Exception e) {
            LOGGER.info("Empty channel");
        }

        LOGGER.info("Try from file");
        channel = client.loadChannelFromConfig(channelName, network);
        channel.initialize();

        LOGGER.info("Channel connection {}", channel.getName());
        LOGGER.info("Client context {}", client.getUserContext().getName());
    }

}
