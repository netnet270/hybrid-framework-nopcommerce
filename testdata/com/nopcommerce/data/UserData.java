package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.GlobalConstants;

public class UserData {
	public static UserData getUserData() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/testdata/com/nopcommerce/data/User.json"), UserData.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	@JsonProperty("first_name")
	String firstname;
	
	@JsonProperty("last_name")
	String lastname;
	
	@JsonProperty("password")
	String password;
	
	@JsonProperty("email")
	String emailAddress;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
}
