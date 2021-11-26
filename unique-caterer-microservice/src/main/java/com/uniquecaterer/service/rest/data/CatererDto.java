package com.uniquecaterer.service.rest.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class CatererDto implements Serializable{

	
	private static final long serialVersionUID = 2251721842608908748L;

	private String id;
	
	private String name;
	
	private LocationDto location;
	
	private CapacityDto capacity;
	
	private ContactDetailsDto contactDetails;
	

}
