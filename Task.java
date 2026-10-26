package task;

public class Task {
	// Attributes private from user input access
	private final String taskId; 
	private String name;
	private String description;
	
	// Constructor parameter validation 
	public Task(String taskId, String name, String description) {
			// Task ID Validation
			if (taskId == null) {
				throw new IllegalArgumentException("Task Id is empty");
				}
			if (taskId.length() > 10) {
				throw new IllegalArgumentException("Task Id limit of 10 characters");
			}
			
			// Name Validation
			if (name == null) {
				throw new IllegalArgumentException("Name is empty");
			}
			if (name.length() > 20) {
				throw new IllegalArgumentException("Name limit of 20 characters");
			}
			// Description Validation
			if (description == null) {
				throw new IllegalArgumentException("Description is empty");
			}
			if (description.length() > 50) {
				throw new IllegalArgumentException("Description field limit of 50 characters");
			}		

			this.taskId = taskId;
			this.name = name;
			this.description = description;
		}
			
		public String getTaskId() {
			return taskId;
		}
		public String getName() {
			return name;
		}
		public String getDescription() {
			return description;
		}
			
		public void setName(String name) {
			//  Repeating checks here to block invalid updates to any fields after creation
			if (name == null) {
					throw new IllegalArgumentException("Name was empty");
			}
			if (name.length() > 20) {
					throw new IllegalArgumentException("Name limit of 20 characters");
			}
			this.name = name;
		}
			
		public void setDescription(String description) {
		//  Repeating checks here to block invalid updates to any fields after creation
			if (description == null) {
				throw new IllegalArgumentException("Description is empty");
			}
			if (description.length() > 50) {
				throw new IllegalArgumentException("Description field limit of 50 characters");
			}
			this.description = description;
		}
}	