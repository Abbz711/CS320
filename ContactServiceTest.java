package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContactServiceTest {
	
	@Test
	public void testAddContactSuccess() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		
		service.addContact(contact);
		// registration pass means absence of exceptions
	}
	
	@Test 
	public void testAddDupeFail() { 
		ContactService service = new ContactService();
		Contact tester1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		Contact tester2 = new Contact("12345", "Jane", "Smith", "0123456789", "888 High Way");
		service.addContact(tester1);
		assertThrows(IllegalArgumentException.class, () -> service.addContact(tester2));		
	}
	
	@Test
	public void testDeleteContactSuccess() { 
		ContactService service = new ContactService(); 
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		service.deleteContact("12345");
	}
	
	@Test
	public void testUpdateContactSuccess() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		
		service.addContact(contact);
		service.updateContact("12345", "Jane", "Smith", "0123456789", "888 High Way");
		service.updateContact("12345", null, null, null, null);
		
		assertEquals("Jane", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("0123456789", contact.getPhone());
		assertEquals("888 High Way", contact.getAddress());
	}
	@Test
	public void testUpdateContactInvalidDataFail() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		
		// invalid length exceptions inside the setters
		assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", "JohnJohnJohn", null, null, null));
		assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", null, "DoeDoeDoeDoe", null, null));
		assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", null, null, "12345", null));
		assertThrows(IllegalArgumentException.class, () -> service.updateContact("12345", null, null, null, "123 Main St, Anywhere, USA, 123456789"));
	}
	
	@Test
	public void testUpdateContactNotFoundFail() {
		ContactService service = new ContactService(); 
		assertThrows(IllegalArgumentException.class, () -> service.updateContact("9999", "Jane", "Smith", "0123456789", "888 High Way"));
	}

	// Parameterized method to eliminate duplicate null and not-found failure tests
	@ParameterizedTest
	@ValueSource(strings = {"99999"})
	@NullSource
	public void testDeleteContactFailures(String testId) {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.deleteContact(testId));
	}

	@Test
	public void testAddContactNullFail() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	}
}
