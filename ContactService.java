package contact;

// imports
import java.util.HashMap;

import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contactMap = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Unassigned contact");
		}
		Contact safe = contact;
		if (contactMap.putIfAbsent(safe.getContactId(), safe) != null) {
				throw new IllegalArgumentException("Contact Assigned, Please try again.");
		}
	}
	// Safely Delete Method
	public void deleteContact(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("This ID is empty.");
		}
		String safeId = contactId;
		if (contactMap.remove(safeId) == null) {
			throw new IllegalArgumentException("Contact ID does not exist.");
			}
		}
 
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {		
		// Securely get contact || throw error if contact is null
		Contact target = contactMap.get(contactId);
		if (target == null) {
			throw new IllegalArgumentException("This contact does not exist.");
		}

		// Securely pass updates through Contact class 
		if (firstName != null) target.setFirstName(firstName);
		if (lastName != null) target.setLastName(lastName);
		if (phone != null) target.setPhone(phone);
		if (address != null) target.setAddress(address);
	}    
}