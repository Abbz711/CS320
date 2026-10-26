package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TaskTest {

	@Test
	public void testTaskCreationSuccess() {
		Task task = new Task("12345", "John", "Doe");
		task.setName("Jane");
		task.setDescription("Smith");
		
		assertEquals("12345", task.getTaskId());
		assertEquals("Jane", task.getName());
		assertEquals("Smith", task.getDescription());
	}
	
	@Test
	public void testTaskCreationLengthFail() {
		assertThrows(IllegalArgumentException.class, () -> new Task("12345", "JaneSmithJaneSmithJaneS", "Smith"));
		assertThrows(IllegalArgumentException.class, () -> new Task("12345", "John", "This description field length is specifically hand-crafted to be over fifty characters looong."));
		assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "John", "Doe"));
	}
	
	// Check to avoid null overflows and attacks 
	@Test
	public void testTaskCreationNullFail() {
		assertThrows(IllegalArgumentException.class, () -> new Task(null, "John", "Doe"));
		assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Doe"));
		assertThrows(IllegalArgumentException.class, () -> new Task("12345", "John", null));
	}

	// Setter for null checks
	@Test
	public void testTaskSettersNullFail() {
		Task task = new Task("12345", "John", "Doe");
		assertThrows(IllegalArgumentException.class, () -> task.setName(null));
		assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
	}
	// Parameterized testing method updated per professor feedback
	@ParameterizedTest
	@ValueSource(strings = {"JaneSmithJaneSmithJaneS"})
	@NullSource
	void testInvalidNames(String testVal){
		assertThrows(IllegalArgumentException.class, () -> new Task("12345", testVal, "Doe"));
	}
	
}
