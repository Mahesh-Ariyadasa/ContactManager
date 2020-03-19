package com.company.contactentry.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.contactentry.dao.ContactDao;
import com.company.contactentry.dto.ContactDTO;
import com.company.contactentry.exceptions.EntityNotFoundException;
import com.company.contactentry.models.Contact;
import com.company.contactentry.util.ContactMapper;

@Service
public class ContactService {

	private ContactDao contactDao;
	
	@Autowired
	public ContactService(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public void deleteEntity(Long id) {
		contactDao.deleteById(id);
	}

	public Set<Contact> getAllEntities() {

		List<ContactDTO> contactDtos = contactDao.getAll();		
		if (contactDtos == null) {
			throw new EntityNotFoundException();
		}
		return contactDtos
				.stream()
				.map(d -> ContactMapper.mapFromDto(d))
				.collect(Collectors.toSet());		

	}
	

	public Contact getEntity(Long id) {

		ContactDTO contactDTO = contactDao.getEntityById(id);
		if (contactDTO == null) {
			throw new EntityNotFoundException();
		}
		return ContactMapper.mapFromDto(contactDTO);

	}

	public Contact saveEntity(Contact contactDetails) {

		ContactDTO contactDTO = ContactMapper.mapToDto(contactDetails);
		return ContactMapper.mapFromDto(contactDao.saveEntity(contactDTO));

	}
}
