package appointment;

import java.util.Date;

public class Appointment {
	// Attributes private from user input access
	private final String appointmentId;
	private final Date appointmentDate;
	private final String description;
	
	// Constructor parameter validation 
	public Appointment(String appointmentId, Date appointmentDate, String description) {
		// Appointment ID Validation
		if (appointmentId == null) {
			throw new IllegalArgumentException("Appointment ID is empty");
		}
		if (appointmentId.length() > 10) {
			throw new IllegalArgumentException("Appointment ID has a limit of 10 characters");
		}
	
		// Appointment Date Validation
		if (appointmentDate == null) {
			throw new IllegalArgumentException("Appointment Date is empty");
		}
		if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Error: Appointment Date cannot be in the past");
		}

		// Description Validation
		if (description == null) {
			throw new IllegalArgumentException("Description is empty");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("Description field has a limit of 50 characters");
		}
	
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public String getDescription() {
		return description;
	}
}
