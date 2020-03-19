package com.company.contactentry.util;

import java.util.HashSet;
import java.util.Set;

import com.company.contactentry.dto.AddressDTO;
import com.company.contactentry.dto.ContactDTO;
import com.company.contactentry.dto.NameDTO;
import com.company.contactentry.dto.PhoneDTO;
import com.company.contactentry.models.Address;
import com.company.contactentry.models.Contact;
import com.company.contactentry.models.Name;
import com.company.contactentry.models.Phone;

public class ContactMapper {
		
	public static Address mapFromDto(AddressDTO addressDto) {
		
		if(addressDto != null) {
			Address address = new Address();
			address.setStreet(addressDto.getStreet());
			address.setState(addressDto.getState());
			address.setCity(addressDto.getCity());
			address.setZip(addressDto.getZip());
			return address;
		}
		
		return null;
		
	}
	
	public static Set<Phone> mapFromDto(Set<PhoneDTO> phoneDtos) {
		
		if(phoneDtos != null && phoneDtos.size() > 0) {
			
			Set<Phone> phones = new HashSet<>();
			
			for(PhoneDTO p : phoneDtos) {
				Phone phone = new Phone();
				phone.setNumber(p.getNumber());
				phone.setType(p.getType());
				phones.add(phone);
			}
			return phones;
		}
		
		return null;
	}
	
	
	public static Name mapFromDto(NameDTO nameDto) {
		if(nameDto != null) {
			Name name = new Name();
			name.setFirst(nameDto.getFirstName());
			name.setMiddle(nameDto.getMiddleName());
			name.setLast(nameDto.getLastName());
			return name;
			
		}
		return null;
	}
	
	public static ContactDTO mapToDto(Contact contactDetails) {
			
		if(contactDetails != null) {
			
			AddressDTO addressDTO = mapToDto(contactDetails.getAddress());
			Set<PhoneDTO> phoneDTO = mapToDto(contactDetails.getPhone());			
			NameDTO nameDTO = mapToDto(contactDetails.getName());			
			ContactDTO contactDTO = new ContactDTO();
			contactDTO.setAddress(addressDTO);
			contactDTO.setPhone(phoneDTO);
			contactDTO.setName(nameDTO);
			contactDTO.setEmail(contactDetails.getEmail());
			contactDTO.setId(contactDetails.getId());
			return contactDTO;
			
		}
			
			return null;
	}
	
	public static AddressDTO mapToDto(Address address) {
		
		if(address != null) {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setStreet(address.getStreet());
			addressDTO.setCity(address.getCity());
			addressDTO.setZip(address.getZip());
			addressDTO.setState(address.getState());
			return addressDTO;
		}
		
		return null;
		
	}
	
	public static Set<PhoneDTO> mapToDto(Set<Phone> phones) {
		
		if(phones != null && phones.size() > 0) {
			
			Set<PhoneDTO> phoneDTOs = new HashSet<>();
			
			for(Phone p : phones) {
				PhoneDTO phoneDTO = new PhoneDTO();
				phoneDTO.setNumber(p.getNumber());
				phoneDTO.setType(p.getType());
				phoneDTOs.add(phoneDTO);
			}
			return phoneDTOs;
		}
		
		return null;
	}
	
	public static NameDTO mapToDto(Name name) {
		if(name != null) {
			NameDTO nameDTO = new NameDTO();
			nameDTO.setFirstName(name.getFirst());
			nameDTO.setMiddleName(name.getMiddle());
			nameDTO.setLastName(name.getLast());
			return nameDTO;
		}
		return null;
	}
	
	public static Contact mapFromDto(ContactDTO contactDTO) {
		
		if(contactDTO != null) {
			Contact contactDetails = new Contact();
			Name name = mapFromDto(contactDTO.getName());
			Address address = mapFromDto(contactDTO.getAddress());
			Set<Phone> phones = mapFromDto(contactDTO.getPhone());
			contactDetails.setAddress(address);
			contactDetails.setPhone(phones);
			contactDetails.setName(name);
			contactDetails.setEmail(contactDTO.getEmail());
			contactDetails.setId(contactDTO.getId());			
			return contactDetails;			
		}
			
		return null;
	}
	
}
