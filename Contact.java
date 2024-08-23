/*************************
 * Name: 	Mohammed Khan
 * Course: 	CS-320 
 * Date: 	July, 16 2024
 * Description: This class represents a contact and must fulfill the requirements for the contact fields.
 *************************/

package Contact;
public class Contact {
    private final String contactId; // Unique contact ID (immutable)
    private String firstName; // First name of the contact
    private String lastName; // Last name of the contact
    private String phoneNumber; // Phone number of the contact
    private String postalAddress; // Address of the contact

    // Constructor to initialize a new contact
    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String postalAddress) {
        // Validate and assign contact ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        // Validate and assign first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // Validate and assign last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // Validate and assign phone number
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        // Validate and assign postal address
        if (postalAddress == null || postalAddress.length() > 30) {
            throw new IllegalArgumentException("Invalid postal address");
        }
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.postalAddress = postalAddress;
    }

    // Getter for contact ID
    public String getContactId() {
        return contactId;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Getter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter for postal address
    public String getPostalAddress() {
        return postalAddress;
    }

    // Setter for first name with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    // Setter for last name with validation
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    // Setter for phone number with validation
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    // Setter for postal address with validation
    public void setPostalAddress(String postalAddress) {
        if (postalAddress == null || postalAddress.length() > 30) {
            throw new IllegalArgumentException("Invalid postal address");
        }
        this.postalAddress = postalAddress;
    }
}