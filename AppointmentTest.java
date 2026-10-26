package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Date;

public class AppointmentTest {
    
	// Future / tomorrow
	@Test
	public void testAppointmentCreationSuccess() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000); 
		Appointment appointment = new Appointment("12345", futureDate, "Valid Description");
		
		assertEquals("12345", appointment.getAppointmentId());
		assertEquals(futureDate, appointment.getAppointmentDate());
		assertEquals("Valid Description", appointment.getDescription());
	}
	
	@Test
	public void testAppointmentCreationLengthFail() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", futureDate, "Valid Description"));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", futureDate, "This description field length is specifically hand-crafted to be over fifty characters looong."));
	}
	
	@Test
	public void testAppointmentCreationDateFail() {
		Date pastDate = new Date(System.currentTimeMillis() - 86400000); // Past Date
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", pastDate, "Valid Description"));
	}
	
	// Check to avoid null overflows and attacks 
	@Test
	public void testAppointmentCreationNullFail() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Valid Description"));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", null, "Valid Description"));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", futureDate, null));
	}

	// Parameterized testing method updated 
	// per professor feedback from week three carried over // reference if forgotten
	@ParameterizedTest
	@ValueSource(strings = {"This description field length is specifically hand-crafted to be over fifty characters looong."})
	@NullSource
	void testInvalidDescriptions(String testVal) {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", futureDate, testVal));
	}
}
