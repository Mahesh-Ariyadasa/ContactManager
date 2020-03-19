package com.company.contactentry.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.contactentry.models.Contact;
import com.company.contactentry.service.ContactService;

@RestController
@RequestMapping(path = "/contacts")
public class Controller extends BaseController {

	private ContactService contactService;

	@Autowired
	public Controller(ContactService contactService) {
		this.contactService = contactService;
	}

	@Override
	@GetMapping("/{id}")
	public Contact getContacts(@PathVariable("id") Long id) {
		return contactService.getEntity(id);
	}

	@Override
	@GetMapping
	public Set<Contact> getAllContacts() {
		return contactService.getAllEntities();
	}

	@Override
	@PostMapping
	public Contact saveContacts(@RequestBody Contact contact) {
		validatePhone(contact);
		return contactService.saveEntity(contact);
	}

	@Override
	@PutMapping("/{id}")
	public Contact updateContacts(@PathVariable("id") Long id, @RequestBody Contact contact) {
		validatePhone(contact);
		Contact resp = contactService.getEntity(id);
		update(contact, resp);
		return contactService.saveEntity(resp);

	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable("id") Long id) {
		contactService.deleteEntity(id);
	}

}
