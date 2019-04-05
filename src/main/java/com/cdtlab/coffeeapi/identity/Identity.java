package com.cdtlab.coffeeapi.identity;

import java.io.Serializable;
import java.util.Set;

import org.hyperledger.fabric.sdk.Enrollment; //https://github.com/hyperledger/fabric-sdk-java/blob/master/src/main/java/org/hyperledger/fabric/sdk/Enrollment.java
import org.hyperledger.fabric.sdk.User;   //https://github.com/hyperledger/fabric-sdk-java/blob/master/src/main/java/org/hyperledger/fabric/sdk/User.java
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class Identity implements User, Serializable {
	private static final long serialVersionUID = 6709711271509594173L;
	private String name;
	private Set<String> roles;
	private String affiliation;
	private Enrollment enrollment;
	private String mspId;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public void setMspId(String mspId) {
		this.mspId = mspId;
	}

	public Identity(String name, String affiliation, Enrollment enrollment, String mspId) {
		super();
		this.name = name;
		this.affiliation = affiliation;
		this.enrollment = enrollment;
		this.mspId = mspId;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Set<String> getRoles() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getAffiliation() {
		// TODO Auto-generated method stub
		return affiliation;
	}

	@Override
	public Enrollment getEnrollment() {
		// TODO Auto-generated method stub
		return enrollment;
	}

	@Override
	public String getMspId() {
		// TODO Auto-generated method stub
		return mspId;
	}

	@Override
	public String toString() {
		return "Identity [name=" + name + ", roles=" + roles + ", affiliation=" + affiliation
				+ ", enrollment=" + enrollment + ", mspId=" + mspId + "]";
	}

	@Override
	public String getAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
