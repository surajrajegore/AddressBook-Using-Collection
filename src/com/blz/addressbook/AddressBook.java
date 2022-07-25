package com.blz.addressbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AddressBook implements AddressBookService {
    Map<String, ContactDetails> contactsList = new HashMap<String, ContactDetails>();
    public static String addressBookName;
    AddressBookMain addressBookMain = new AddressBookMain();
    Address address = new Address();

    public static String getAddressBookName() {
        return addressBookName;
    }

    public static void setAddressBookName(String addressBookName) {
        AddressBook.addressBookName = addressBookName;
    }

    @Override
    public void addContact(ContactDetails contact) {
        contactsList.put(contact.getFirstName(), contact);
    }

    @Override
    public void displayContact() {
        System.out.println("Contacts of the addressbook " + AddressBook.getAddressBookName());
        for (String contacts : contactsList.keySet()) {
            ContactDetails contactDetails = contactsList.get(contacts);
        }
    }

    @Override
    public void operationOfAddressBook() {
        int choice = 0;
        do {
            System.out.println("Which operation you want to perform ");
            System.out.println("1. Add contact\n2. Edit Existing contact\n3. Display contacts book\n4. Delete record\n5.Exit.");
            choice = UserInput.getInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter how many records you want to insert.... ");
                    int numberOfRecords = UserInput.getInt();
                    int i = 0;
                    while (i < numberOfRecords) {
                        addContact(addressBookMain.setContactDetails());
                        i++;
                    }

                    break;
                case 2:
                    editDetails();
                    break;
                case 3:
                    displayContact();
                    break;
                case 4:
                    deleteDetails();
                    break;
                case 5:
                    System.out.println("Terminated...");
                    break;
                default:
                    System.out.println("Kindly enter a valid input...");
                    operationOfAddressBook();
                    break;
            }
        } while (choice != 5);
    }

    @Override
    public void editDetails() {
        ContactDetails contactDetails = new ContactDetails();
        System.out.println("Enter first name that you want to update");
        String firstNameWantToEdit = UserInput.getString();
        if (contactsList.containsKey(firstNameWantToEdit)) {
            contactDetails = contactsList.get(firstNameWantToEdit);
            Address address = contactDetails.getAddress();
            System.out.println("\nSelect which one you want to update : ");
            System.out.println("1. Firstname\n2. Last Name\n3. Phone Number\n4. Email\n5. City\n6. State\n7. ZipCode\n8. Back");
            int choice = UserInput.getInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the correct First Name :");
                    contactDetails.setFirstName(UserInput.getString());
                    System.out.println("Updated!");
                    break;
                case 2:
                    System.out.println("Enter the correct Last Name :");
                    contactDetails.setLastName(UserInput.getString());
                    System.out.println("Updated!");

                    break;
                case 3:
                    System.out.println("Enter the correct Phone Number :");
                    contactDetails.setPhoneNumber(UserInput.getLong());
                    System.out.println("Updated!");
                    break;
                case 4:
                    System.out.println("Enter the correct Email Address :");
                    contactDetails.seteMail(UserInput.getString());
                    System.out.println("Updated!");
                    break;
                case 5:
                    System.out.println("Enter the correct City :");
                    address.setCityName(UserInput.getString());
                    System.out.println("Updated!");
                    break;
                case 6:
                    System.out.println("Enter the correct State :");
                    address.setState(UserInput.getString());
                    System.out.println("Updated!");
                    break;
                case 7:
                    System.out.println("Enter the correct ZipCode :");
                    address.setZipCode(UserInput.getLong());
                    System.out.println("Updated!");
                    break;
                case 8:
                    System.out.println("Edit Section got terminated");
                    operationOfAddressBook();
                default:
                    System.out.println("Kindly enter a valid input");
                    break;
            }

        } else {
            System.out.println("Contact not found...");
        }
    }

    public void deleteDetails() {
        String name = "";
        System.out.println("Enter name that you want to delete....");
        name = UserInput.getString();
        if (contactsList.containsKey(name)) {
            contactsList.remove(name);
            System.out.println(" contact removed!");
        } else {
            System.out.println("Contact not found...");
        }
    }
}


