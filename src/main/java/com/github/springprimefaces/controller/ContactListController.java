package com.github.springprimefaces.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * @author elvis
 * @version $Revision: $<br/>
 * $Id: $
 * @since 8/12/16 10:57 AM
 */

@ManagedBean
@Scope("view")
@Controller("ContactListController")
public class ContactListController {

	List<String> contacts = new ArrayList<>();
	private String currentContact = "New Contact";

	public void addContact(String contact) {
		contacts.add(contact);
		this.currentContact = "";
	}

	public List<String> getContacts() {
		return contacts;
	}

	public String getCurrentContact() {
		return currentContact;
	}

	public void setCurrentContact(String currentContact) {
		this.currentContact = currentContact;
	}

}
