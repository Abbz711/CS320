package task;

// imports
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private final Map<String, Task> taskMap = new HashMap<>();	

	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("This task is empty.");
		}
		Task safe = task;
		if (taskMap.putIfAbsent(safe.getTaskId(), safe) != null) {
				throw new IllegalArgumentException("Task is already assigned, please try again.");
		}
	}
	// Safely Delete Method
	public void deleteTask(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("Task ID is empty.");
		}
		String safeId = taskId;
		if (taskMap.remove(safeId) == null) {
			throw new IllegalArgumentException("Task ID does not exist.");
			}
		}
 
	public void updateTask(String taskId, String name, String description) {		
		// get task || throw error if task is null
		Task target = taskMap.get(taskId);
		if (target == null) {
			throw new IllegalArgumentException("This task does not exist.");
		}

		// Safely pass updates through Task class 
		if (name != null) target.setName(name);
		if (description != null) target.setDescription(description);
	}    
}
