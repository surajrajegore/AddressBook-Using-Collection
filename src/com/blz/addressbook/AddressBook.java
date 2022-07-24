package com.blz.addressbook;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressBook implements AddressBookService {
    ArrayList<ContactDetails> contactsList = new ArrayList<>();

    @Override
    public void addContact(ContactDetails contact) {
        contactsList.add(contact);
    }

    @Override
    public void displayContact() {
        Iterator<ContactDetails> iterator = contactsList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

