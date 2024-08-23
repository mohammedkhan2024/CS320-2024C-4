/*************************
 * Name: 	Mohammed Khan
 * Course: 	CS-320 
 * Date: 	July, 16 2024
 * Description: This class manage the contacts, allowing adding, deleting, and updating contacts.
 *************************/

package Contact;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Map to store contacts with contact ID as the key
    private Map<String, Contact> contactMap = new HashMap<>();

    // Method to add a new contact
    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contactMap.put(contact.getContactId(), contact);
    }

    // Method to delete a contact by ID
    public void removeContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contactMap.remove(contactId);
    }

    // Method to update contact details by ID
    public void modifyContact(String contactId, String firstName, String lastName, String phoneNumber, String postalAddress) {
        Contact contact = contactMap.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        // Update first name if provided and valid
        if (firstName != null && firstName.length() <= 10) {
            contact.setFirstName(firstName);
        }
        // Update last name if provided and valid
        if (lastName != null && lastName.length() <= 10) {
            contact.setLastName(lastName);
        }
        // Update phone number if provided and valid
        if (phoneNumber != null && phoneNumber.length() == 10) {
            contact.setPhoneNumber(phoneNumber);
        }
        // Update postal address if provided and valid
        if (postalAddress != null && postalAddress.length() <= 30) {
            contact.setPostalAddress(postalAddress);
        }
    }

    // Method to get a contact by ID
    public Contact retrieveContact(String contactId) {
        return contactMap.get(contactId);
    }
}
