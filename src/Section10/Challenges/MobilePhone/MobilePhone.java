package Section10.Challenges.MobilePhone;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private final ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact... contacts) {
        boolean addedAny = false;
        for (Contact contact : contacts) {
            if (findContact(contact) == -1) {
                myContacts.add(contact);
                addedAny = true;
            }
        }
        return addedAny;
    }


    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (!myContacts.contains(oldContact)) {
            System.out.println("Contact not found");
            return false;
        }
        myContacts.set(myContacts.indexOf(oldContact), newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (!myContacts.contains(contact)) {
            System.out.println("Contact not found");
            return false;
        }
        myContacts.remove(contact);
        return true;

    }

    private int findContact(Contact contact) {
        if (!myContacts.contains(contact)) {
            System.out.println("Contact not found");
            return -1;
        }
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
       if(findContact(name) == -1) {
           System.out.println("Contact not found");
           return null;
       }
       return myContacts.get(findContact(name));
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }


}
