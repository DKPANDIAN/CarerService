package com.uniquecaterer.service.rest.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContactDetailsDto implements Serializable{
	
	private static final long serialVersionUID = -6415351410336944910L;
	
	private String phoneNumber;

	private String mobileNumber;

	private String emailAddress;

}
