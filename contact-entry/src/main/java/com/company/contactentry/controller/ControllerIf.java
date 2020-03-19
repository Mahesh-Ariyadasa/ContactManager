package com.company.contactentry.controller;

import java.util.Set;

import com.company.contactentry.models.Contact;

public interface ControllerIf {

	Contact getContacts(Long id);

	Set<Contact> getAllContacts();

	Contact saveContacts(Contact contactDetails);

	Contact updateContacts(Long id, Contact contactDetails);

	void deleteContact(Long id);

	
}
