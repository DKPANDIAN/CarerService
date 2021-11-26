package com.uniquecaterer.service.rest.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class LocationDto implements Serializable {

	private static final long serialVersionUID = -4297434829872787536L;

	private String city;

	private String street;

	private String postCode;

}
