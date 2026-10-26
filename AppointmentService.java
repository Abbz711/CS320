package appointment;

// imports
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	private final Map<String, Appointment> appointmentMap = new HashMap<>();	

	public void addAppointment(Appointment appointment) {
		if (appointment == null) {
			throw new IllegalArgumentException("This appointment is empty.");
		}
		Appointment safe = appointment;
		if (appointmentMap.putIfAbsent(safe.getAppointmentId(), safe) != null) {
				throw new IllegalArgumentException("Appointment is already assigned, Please pick a different date and again.");
		}
	}
	
	// Safely Delete Method
	public void deleteAppointment(String appointmentId) {
		if (appointmentId == null) {
			throw new IllegalArgumentException("This ID is empty.");
		}
		String safeId = appointmentId;
		if (appointmentMap.remove(safeId) == null) {
			throw new IllegalArgumentException("The Appointment ID does not exist.");
			}
		}
}
