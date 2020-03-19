package com.company.contactentry.controller;

import java.util.Set;

import org.springframework.util.StringUtils;

import com.company.contactentry.exceptions.ContactValidateException;
import com.company.contactentry.models.Contact;
import com.company.contactentry.models.Phone;
import com.company.contactentry.util.ContactConstants;

public abstract class BaseController implements ControllerIf {

	public void update(Contact source, Contact dest) {

		if (!StringUtils.isEmpty(source.getEmail())) {
			dest.setEmail(source.getEmail());
		}

		if (source.getAddress() != null) {
			if (dest.getAddress() == null) {
				dest.setAddress(source.getAddress());
			} else {
				if (!StringUtils.isEmpty(source.getAddress().getStreet())) {
					dest.getAddress().setStreet(source.getAddress().getStreet());
				}
				if (!StringUtils.isEmpty(source.getAddress().getState())) {
					dest.getAddress().setState(source.getAddress().getState());
				}
				if (!StringUtils.isEmpty(source.getAddress().getZip())) {
					dest.getAddress().setZip(source.getAddress().getZip());
				}
				if (!StringUtils.isEmpty(source.getAddress().getCity())) {
					dest.getAddress().setCity(source.getAddress().getCity());
				}
			}
		}

		if (source.getName() != null) {
			if (dest.getName() == null) {
				dest.setName(source.getName());
			} else {
				if (!StringUtils.isEmpty(source.getName().getFirst())) {
					dest.getName().setFirst(source.getName().getFirst());
				}
				if (!StringUtils.isEmpty(source.getName().getMiddle())) {
					dest.getName().setMiddle(source.getName().getMiddle());
				}
				if (!StringUtils.isEmpty(source.getName().getLast())) {
					dest.getName().setLast(source.getName().getLast());
				}
			}
		}

		if (source.getPhone() != null) {
			if (dest.getPhone() == null) {
				dest.setPhone(source.getPhone());
			} else {
				Set<Phone> phone = source.getPhone();
				for (Phone p : phone) {
					Phone oldPhone = getPhoneFromType(dest.getPhone(), p.getType());
					if (oldPhone != null) {
						oldPhone.setNumber(p.getNumber());
					} else {
						dest.getPhone().add(p);
					}

				}
			}
		}

	}

	public Phone getPhoneFromType(Set<Phone> phoneSet, String type) {
		for (Phone p : phoneSet) {
			if (p.getType().equals(type)) {
				return p;
			}
		}
		return null;

	}

	public void validatePhone(Contact contactDetails) {

		if (contactDetails != null && contactDetails.getPhone() != null) {
			for (Phone p : contactDetails.getPhone()) {
				if (!ContactConstants.PHONETYPES.contains(p.getType())) {
					throw new ContactValidateException("Only mobile|home|work allowed for phone type");

				}
			}
		}

	}

}
