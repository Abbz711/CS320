package contact;


public class Contact {
	// Attributes
	private final String contactId; 
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor parameter validation 
	
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// Validate against nulls 
		if (contactId == null) {
			throw new IllegalArgumentException("Contact Id is empty");
		}
		if (contactId.length() > 10) {
			throw new IllegalArgumentException("Contact Id limit of 10 characters");
		}
	
		// First Name Validation
		if (firstName == null) {
			throw new IllegalArgumentException("First Name was empty");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("First Name limit of 10 characters");
		}
		// Last Name Validation
		if (lastName == null) {
			throw new IllegalArgumentException("Last Name is empty");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last Name limit of 10 characters");
		}
		// Phone Number Validation
		if (phone == null) {
			throw new IllegalArgumentException("Phone Number is empty");
		}
		if (phone.length() != 10) {
			throw new IllegalArgumentException("Phone Number needs to be exactly 10 characters");
		}
		// Address Validation
		if (address == null) {
			throw new IllegalArgumentException("Address is empty");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("Address field limit of 30 characters");
		}
	
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public String getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	public void setFirstName(String firstName) {
		//  Repeating checks here to block invalid updates to any fields after creation
		if (firstName == null) {
			throw new IllegalArgumentException("First Name was empty");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("First Name limit of 10 characters");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last Name is empty");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last Name limit of 10 characters");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("Phone Number is empty");
		}
		if (phone.length() != 10) {
			throw new IllegalArgumentException("Phone Number needs to be exactly 10 characters");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address is empty");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("Address field limit of 30 characters");
		}
		this.address = address;
	}

}	