/*************************
 * Name: 	Mohammed Khan
 * Course: 	CS-320 
 * Date: 	July, 16 2024
 * Description: This class contain the unit tests for the ContactService class.
 *************************/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService(); // Initialize ContactService before each test
    }

    @Test
    public void testAddContact() {
        // Test adding a valid contact
        Contact contact = new Contact("12345", "Alice", "Smith", "9876543210", "789 Oak Street");
        service.addContact(contact);
        assertEquals(contact, service.retrieveContact("12345"));
    }

    @Test
    public void testAddContactWithExistingId() {
        // Test adding a contact with an existing ID
        Contact contact1 = new Contact("12345", "Alice", "Smith", "9876543210", "789 Oak Street");
        Contact contact2 = new Contact("12345", "Bob", "Jones", "0123456789", "123 Elm Street");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testRemoveContact() {
        // Test removing an existing contact
        Contact contact = new Contact("12345", "Alice", "Smith", "9876543210", "123 Oak Street");
        service.addContact(contact);
        service.removeContact("12345");
        assertNull(service.retrieveContact("12345"));
    }

    @Test
    public void testRemoveNonExistentContact() {
        // Test removing a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            service.removeContact("54321");
        });
    }

    @Test
    public void testModifyContact() {
        // Test updating contact details
        Contact contact = new Contact("12345", "Alice", "Smith", "9876543210", "123 Oak Street");
        service.addContact(contact);
        service.modifyContact("12345", "Bob", "Johnson", "0123456789", "123 Elm Street");
        assertEquals("Bob", contact.getFirstName());
        assertEquals("Johnson", contact.getLastName());
        assertEquals("0123456789", contact.getPhoneNumber());
        assertEquals("123 Elm Street", contact.getPostalAddress());
    }

    @Test
    public void testModifyNonExistentContact() {
        // Test updating a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            service.modifyContact("54321", "Bob", "Johnson", "0123456789", "123 Elm Street");
        });
    }
}
