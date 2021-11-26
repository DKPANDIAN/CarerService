package com.uniquecaterer.service.rest.data;

import java.io.Serializable;

import javax.validation.constraints.Positive;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
public class CapacityDto implements Serializable{

	private static final long serialVersionUID = 398147699664499659L;

	Integer minGuests;
	
	Integer maxGuests;
	
}
