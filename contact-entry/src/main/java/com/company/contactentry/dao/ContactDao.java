package com.company.contactentry.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.contactentry.dto.ContactDTO;
import com.company.contactentry.repo.ContactRepository;

@Service
public class ContactDao {

	@Autowired
	private ContactRepository contactRepository;
	
	public ContactDao(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	public ContactDTO saveEntity(ContactDTO dto) {
		return contactRepository.save(dto);
	}
	
	public ContactDTO getEntityById(Long id) {
		Optional<ContactDTO> resp = contactRepository.findById(id);
		if(resp.isPresent()) {
			return resp.get();
		}else {
			return null;
		}
	}
	
	public List<ContactDTO> getAll(){
		return contactRepository.findAll();
	}
	
	
	public void deleteById(Long id) {
		contactRepository.deleteById(id);
	}
}
