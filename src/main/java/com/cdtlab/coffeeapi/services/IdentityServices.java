package com.cdtlab.coffeeapi.services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.hyperledger.fabric_ca.sdk.RegistrationRequest;
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
	private String walletPATH = "./wallet/";
	
	public List<IdentityDTO> listIdentities(){
		List<IdentityDTO> identitiesReturn = new ArrayList<>();

		File wallet = new File(walletPATH);
		File[] identities = wallet.listFiles();

		for (int it = 0; it < identities.length; it++){
			identitiesReturn.add(new IdentityDTO(identities[it].getName()));

		}

		return identitiesReturn;
	}

	public Identity checkIdentity(String identityName) throws ClassNotFoundException, IOException{
		identity = null;
		String credentialPATH = walletPATH + identityName + ".dat";

		if(Files.exists(Paths.get(credentialPATH))){
			identity = deserializeObject(credentialPATH);
		}

		return identity;
	}

	public String registerIdentity(HFCAClient caClient, String newUser, String organizationName){
		String response = "Error";

		try{
			String filePath = walletPATH + "adminca" + organizationName + ".dat";
			Identity adminca = deserializeObject(filePath);

			if(adminca == null){
				Enrollment adminEnrollment =  caClient.enroll("admin", "adminpw");
				adminca = new Identity("adminca" + organizationName, organizationName, organizationName + "MSP", adminEnrollment);

				serializeObject(filePath, adminca);
			}

			RegistrationRequest registrationRequest =  new RegistrationRequest(newUser, organizationName);
			String enrollmentSecret = caClient.register(registrationRequest, adminca);
			Enrollment enrollment = caClient.enroll(newUser, enrollmentSecret);

			Identity identityTmp = new Identity(newUser, organizationName, organizationName + "MSP", enrollment);

			serializeObject(walletPATH + newUser + ".dat", identityTmp);
		} catch (Exception e){
			e.printStackTrace();
		}

		return "response :" + response;
	}

	private void serializeObject(String path, Identity identity) throws IOException {
		File f = new File(path);
		if(!f.exists()){
			f.createNewFile();
		}

		FileOutputStream arquivoGrav = new FileOutputStream(f);
		ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

		objGravar.writeObject(identity);
		objGravar.flush();
		objGravar.close();

		arquivoGrav.flush();
		arquivoGrav.close();

	}

	private Identity deserializeObject(String filePATH) throws ClassNotFoundException, IOException {
		File file = new File(filePATH);
		if(!file.exists()){
			return null;
		}

		FileInputStream fileReading = new FileInputStream(file);
		ObjectInputStream objReading = new ObjectInputStream(fileReading);

		Identity identity = (Identity) objReading.readObject();

		objReading.close();
		fileReading.close();

		return identity;

	}

}
