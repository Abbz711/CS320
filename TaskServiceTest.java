package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TaskServiceTest {
	
	@Test
	public void testAddTaskSuccess() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "John", "Doe");
		
		service.addTask(task);
		// registration pass means absence of exceptions
	}
	
	@Test 
	public void testAddTaskDupeFail() { 
		TaskService service = new TaskService();
		Task tester1 = new Task("12345", "John", "Doe");
		Task tester2 = new Task("12345", "Jane", "Smith");
		service.addTask(tester1);
		assertThrows(IllegalArgumentException.class, () -> service.addTask(tester2));		
	}
	
	@Test
	public void testDeleteTaskSuccess() { 
		TaskService service = new TaskService(); 
		Task task = new Task("12345", "John", "Doe");
		service.addTask(task);
		service.deleteTask("12345");
	}
	
	@Test
	public void testUpdateTaskSuccess() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "John", "Doe");
		
		service.addTask(task);
		service.updateTask("12345", "Jane", "Smith");
		service.updateTask("12345", null, null);
		
		assertEquals("Jane", task.getName());
		assertEquals("Smith", task.getDescription());
	}
	
	@Test
	public void testUpdateTaskInvalidDataFail() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "John", "Doe");
		service.addTask(task);
		
		// invalid length exceptions inside the setters
		assertThrows(IllegalArgumentException.class, () -> service.updateTask("12345", "JaneSmithJaneSmithJaneS", null));
		assertThrows(IllegalArgumentException.class, () -> service.updateTask("12345", null, "This description field length is specifically hand-crafted to be over fifty characters looong."));
	}
	
	@Test
	public void testUpdateTaskNotFoundFail() {
		TaskService service = new TaskService(); 
		assertThrows(IllegalArgumentException.class, () -> service.updateTask("9999", "Jane", "Smith"));
	}

	// Parameterized method to eliminate duplicate null and not-found failure tests
	@ParameterizedTest
	@ValueSource(strings = {"99999"})
	@NullSource
	public void testDeleteTaskFailures(String testId) {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.deleteTask(testId));
	}

	@Test
	public void testAddTaskNullFail() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.addTask(null));
	}
}
