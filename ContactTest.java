package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ContactTest {

	@Test
	public void testContactCreationSuccess() {
			Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
			contact.setFirstName("Jane");
			contact.setLastName("Smith");
			contact.setPhone("0123456789");
			contact.setAddress("888 High Way");
			
			assertEquals("12345", contact.getContactId());
			assertEquals("Jane", contact.getFirstName());
			assertEquals("Smith", contact.getLastName());
			assertEquals("0123456789", contact.getPhone());
			assertEquals("888 High Way", contact.getAddress());
			
	}
	
	@Test
	public void testContactCreationLengthFail() {
			assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Smith", "12345678901", "888 High Way"));
			assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", "123 Main St, Anywhere, USA, 123456789"));
			assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
			assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "JohnJohnJohn", "Doe", "1234567890", "123 Main St"));
			assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
			}
	
	// Null check to avoid system overflows and attacks 
	@Test
	public void testContactCreationNullFail() {
	    // 1. Contact ID null check
	    assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
	    // 2. First Name null check
	    assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Doe", "1234567890", "123 Main St"));
	    // 3. Last Name null check
	    assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", null, "1234567890", "123 Main St"));   	
	    // 4. Phone Number null check
	    assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", null, "123 Main St"));
	    // 5. Address null check
	    assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", null));
	    	
	}

    // SetterS for null checks
	@Test
	public void testContactSettersNullFail() {
			Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
			assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
			assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
			assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
			assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}
} 