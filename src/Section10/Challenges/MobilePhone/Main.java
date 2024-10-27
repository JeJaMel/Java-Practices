package Section10.Challenges.MobilePhone;

public class Main {
    public static void main(String[] args) {
        // Create a new MobilePhone with a sample number
        MobilePhone mobilePhone = new MobilePhone("555-000000");

        // Create contacts using the createContact method
        Contact pache = Contact.createContact("Pache", "4567-891234");
        Contact tomas = Contact.createContact("Tomas", "7890-123456");
        Contact marco = Contact.createContact("Marco", "2345-678901");
        Contact potro = Contact.createContact("Potro", "6789-012345");
        Contact busta = Contact.createContact("Busta", "8901-234567");
        Contact jejas = Contact.createContact("Jejas", "3456-789012");

        // Add contacts to the mobile phone
        mobilePhone.addNewContact(pache);
        mobilePhone.addNewContact(tomas);
        mobilePhone.addNewContact(marco);
        mobilePhone.addNewContact(potro);
        mobilePhone.addNewContact(busta);
        mobilePhone.addNewContact(jejas);

        // Print all contacts
        System.out.println("Initial contact list:");
        mobilePhone.printContacts();

        // Update a contact (e.g., updating "Tomas" to a new number)
        Contact newTomas = Contact.createContact("Tomas", "1234-567890");
        mobilePhone.updateContact(tomas, newTomas);

        // Print contacts after update
        System.out.println("\nContact list after updating Tomas's number:");
        mobilePhone.printContacts();

        // Remove a contact (e.g., removing "Busta")
        mobilePhone.removeContact(busta);

        // Print contacts after removal
        System.out.println("\nContact list after removing Busta:");
        mobilePhone.printContacts();

        // Query a contact by name
        String queryName = "Marco";
        Contact foundContact = mobilePhone.queryContact(queryName);
        if (foundContact != null) {
            System.out.println("\nFound contact: " + foundContact.getName() + " -> " + foundContact.getPhoneNumber());
        } else {
            System.out.println("\nContact with name " + queryName + " not found.");
        }
    }
}
