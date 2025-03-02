
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact)); // Duplicate ID
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        service.addContact(contact);
        service.deleteContact("12345");
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", "Jane", null, null, null));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        service.addContact(contact);
        service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Oak Street");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Street", contact.getAddress());
    }
}
