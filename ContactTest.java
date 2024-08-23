/*************************
 * Name: 	Mohammed Khan
 * Course: 	CS-320 
 * Date: 	July, 16 2024
 * Description: This class contain the unit tests for the Contact class.
 *************************/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        // Test valid contact creation
        Contact contact = new Contact("12345", "Alice", "Smith", "9876543210", "123 Oak Street");
        assertEquals("12345", contact.getContactId());
        assertEquals("Alice", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("9876543210", contact.getPhoneNumber());
        assertEquals("123 Oak Street", contact.getPostalAddress());
    }

    @Test
    public void testInvalidContactId() {
        // Test contact creation with invalid ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Alice", "Smith", "9876543210", "123 Oak Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Alice", "Smith", "9876543210", "123 Oak Street");
        });
    }

    @Test
    public void testInvalidFirstName() {
        // Test contact creation with invalid first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Smith", "9876543210", "123 Oak Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "ThisNameIsTooLong", "Smith", "9876543210", "123 Oak Street");
        });
    }

    @Test
    public void testInvalidLastName() {
        // Test contact creation with invalid last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Alice", null, "9876543210", "123 Oak Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Alice", "ThisNameIsTooLong", "9876543210", "123 Oak Street");
        });
    }

    @Test
    public void testInvalidPhoneNumber() {
        // Test contact creation with invalid phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Alice", "Smith", null, "123 Oak Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Alice", "Smith", "12345", "123 Oak Street");
        });
    }

    @Test
    public void testInvalidPostalAddress() {
        // Test contact creation with invalid postal address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Alice", "Smith", "9876543210", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Alice", "Smith", "9876543210", "This address is definitely way too long to be accepted");
        });
    }
}
