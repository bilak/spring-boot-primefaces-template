package com.github.springprimefaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 8/12/16 10:57 AM
 */

@ManagedBean
@Scope("view")
@Controller("ContactListController")
public class ContactListController {

    private String currentContact = "New Contact";

    List<String> contacts = new ArrayList<>();

    public void addContact(String contact){
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
