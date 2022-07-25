package com.blz.addressbook;

import java.util.HashMap;
import java.util.Map;

public class AddressBookDirectory implements AddressBookDirectoryInterface{
    public AddressBook addressBook;
    Map<String,AddressBook> addressBookDirectory = new HashMap<String,AddressBook>();

    @Override
    public void operationDirectory() {
        boolean condition = true;
        do {
            System.out.println("\nSelect any option : \n\n1. Add AddressBook"
                    + "\n2. Edit Existing Addressbook\n3. Display Addressbook"
                    + "\n"+4.+". Exit");
            switch(UserInput.getInt()) {
                case 1:
                    addAddressBook();
                    break;
                case 2:
                    editAddressBook();
                    break;
                case 3:
                    displayDirectoryDetails();
                    break;
                case 4:
                    System.out.println("Terminated....");
                    break;
                default:
                    System.out.println("Kindly Enter a valid input!");
            }
        }while(UserInput.getInt() != 4);
    }

    @Override
    public void addAddressBook() {
        AddressBook addressBook = new AddressBook();
        System.out.println("Enter the AddressBook name you want to add ?");
        String bookName = UserInput.getString();
        if(addressBookDirectory.containsKey(bookName)) {
            System.out.println("Book with that name already exist");
        }else {
            addressBook.setAddressBookName(bookName);
            addressBookDirectory.put(bookName, addressBook);
            System.out.println("\nCreated a AddressBook : "+bookName);
        }
    }

    @Override
    public void editAddressBook() {
        System.out.println("Enter the AddressBook name on which you want to add the details");
        String bookName = UserInput.getString();
        if(addressBookDirectory.containsKey(bookName)) {
            addressBook = addressBookDirectory.get(bookName);
            addressBook.operationOfAddressBook();
        }else
            System.out.println("Book with that name doesn't exist..");
    }

    @Override
    public void displayDirectoryDetails() {
        System.out.println("----- Address Book Details -----");
        for (String completeAddressBook : addressBookDirectory.keySet()) {

            System.out.println(completeAddressBook);
        }
        System.out.println("-----------------------------------------");
    }
}
