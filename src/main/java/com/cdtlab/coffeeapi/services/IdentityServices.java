package com.cdtlab.coffeeapi.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cdtlab.coffeeapi.dto.IdentityDTO;
import com.cdtlab.coffeeapi.identity.Identity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Service
@NoArgsConstructor
public class IdentityServices {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	private Identity identity;
	private String walletPath = "./wallet/";
	
	public List<IdentityDTO> listIdentities(){
		List<IdentityDTO> identitiesReturn = new ArrayList<>();
		
		
		
		return identitiesReturn;
	}

}
