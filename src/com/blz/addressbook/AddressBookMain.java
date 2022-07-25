package com.blz.addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook in By using collection");
        AddressBookDirectoryInterface addressBookDirectoryInterface = new AddressBookDirectory();
        addressBookDirectoryInterface.operationDirectory();

    }

    public ContactDetails setContactDetails() {
        ContactDetails contactDetails = new ContactDetails();
        Address address = new Address();
        UserInput userInput = new UserInput();

        System.out.println("Enter First Name:");
        contactDetails.setFirstName(UserInput.getString());

        System.out.println("Enter Last Name:");
        contactDetails.setLastName(UserInput.getString());

        System.out.println("Enter Phone Number:");
        contactDetails.setPhoneNumber(UserInput.getLong());

        System.out.println("Enter City Name:");
        address.setCityName(UserInput.getString());

        System.out.println("Enter State Name:");
        address.setState(UserInput.getString());

        System.out.println("Enter Zip Code:");
        address.setZipCode(UserInput.getLong());

        System.out.println("Enter Email Address:");
        contactDetails.seteMail(UserInput.getString());
        contactDetails.setAddress(address);

        return contactDetails;

    }

}
