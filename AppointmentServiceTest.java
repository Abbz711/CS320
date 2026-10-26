package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Date;

public class AppointmentServiceTest {
	
	@Test
	public void testAddAppointmentSuccess() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment appointment = new Appointment("12345", futureDate, "Valid Description");
		
		service.addAppointment(appointment);
		// registration pass means absence of exceptions
	}
	
	@Test 
	public void testAddAppointmentDupeFail() { 
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment tester1 = new Appointment("12345", futureDate, "Valid Description");
		Appointment tester2 = new Appointment("12345", futureDate, "Another Description");
		
		service.addAppointment(tester1);
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(tester2));		
	}
	
	@Test
	public void testDeleteAppointmentSuccess() { 
		AppointmentService service = new AppointmentService(); 
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment appointment = new Appointment("12345", futureDate, "Valid Description");
		
		service.addAppointment(appointment);
		service.deleteAppointment("12345");
	}

	// Parameterized method to eliminate duplicate null and not-found failure tests
	@ParameterizedTest
	@ValueSource(strings = {"99999"})
	@NullSource
	public void testDeleteAppointmentFailures(String testId) {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(testId));
	}

	@Test
	public void testAddAppointmentNullFail() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(null));
	}
}