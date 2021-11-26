package com.uniquecaterer.service.rest.data;

import org.springframework.stereotype.Component;

import com.uniquecaterer.service.rest.entity.Capacity;
import com.uniquecaterer.service.rest.entity.Caterer;
import com.uniquecaterer.service.rest.entity.ContactDetails;
import com.uniquecaterer.service.rest.entity.Location;

@Component
public class CatererDataFactory {

	public Caterer getCatererEntity(CatererDto catererDto) {

		if (catererDto != null) {
			Caterer caterer = new Caterer();
			Location location = new Location();
			ContactDetails contact = new ContactDetails();
			Capacity capacity = new Capacity();

			caterer.setName(catererDto.getName());
			caterer.setId(catererDto.getId());

			if (catererDto.getLocation() != null) {
				location.setCity(catererDto.getLocation().getCity());
				location.setStreet(catererDto.getLocation().getStreet());
				location.setPostCode(catererDto.getLocation().getPostCode());
			}

			if (catererDto.getCapacity() != null) {
				capacity.setMinGuests(catererDto.getCapacity().getMinGuests());
				capacity.setMaxGuests(catererDto.getCapacity().getMaxGuests());
			}

			if (catererDto.getContactDetails() != null) {
				contact.setPhoneNumber(catererDto.getContactDetails().getPhoneNumber());
				contact.setMobileNumber(catererDto.getContactDetails().getMobileNumber());
				contact.setEmailAddress(catererDto.getContactDetails().getEmailAddress());
			}

			caterer.setLocation(location);
			caterer.setContactDetails(contact);
			caterer.setCapacity(capacity);
			return caterer;
		}

		return null;
	}

	public CatererDto getCatererDto(Caterer caterer) {

		if (caterer != null) {
			CatererDto catererDto = new CatererDto();
			LocationDto location = new LocationDto();
			ContactDetailsDto contact = new ContactDetailsDto();
			CapacityDto capacity = new CapacityDto();

			catererDto.setName(caterer.getName());
			catererDto.setId(caterer.getId());
			
			if (caterer.getLocation() != null) {
				location.setCity(caterer.getLocation().getCity());
				location.setStreet(caterer.getLocation().getStreet());
				location.setPostCode(caterer.getLocation().getPostCode());
			}

			if (caterer.getCapacity() != null) {
				capacity.setMinGuests(caterer.getCapacity().getMinGuests());
				capacity.setMaxGuests(caterer.getCapacity().getMaxGuests());
			}

			if (caterer.getContactDetails() != null) {
				contact.setPhoneNumber(caterer.getContactDetails().getPhoneNumber());
				contact.setMobileNumber(caterer.getContactDetails().getMobileNumber());
				contact.setEmailAddress(caterer.getContactDetails().getEmailAddress());
			}

			catererDto.setLocation(location);
			catererDto.setContactDetails(contact);
			catererDto.setCapacity(capacity);
			return catererDto;
		}

		return null;
	}
}
