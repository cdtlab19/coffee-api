package com.cdtlab.coffeeapi.connections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class SessionConnection {
    @Autowired
    private NetworkFabricConnection networkFabric;

    @Autowired
    private ConnectionFabric connectionFabric;

    @Autowired
    private ChannelFabricConnection channelFabric;

    @Autowired
    private CaFabricConnection caFabric;
}
