package com.app.operations;

import java.time.LocalDate;
import java.util.HashMap;

import com.app.core.Task;
import com.app.utils.StatusEnum;

public class TaskListImplemeantation implements TaskManager {
	private HashMap<Integer, Task> taskMap;

	public TaskListImplemeantation() {

		this.taskMap = new HashMap<>();

		// Creating dummy tasks
		addTask("Complete project report", "Finalize the quarterly project report and submit to manager", "2025-04-10",
				"PENDING");
		addTask("Team meeting", "Weekly sync-up with the development team", "2025-04-08", "IN_PROGRESS");
		addTask("Code review", "Review code submissions from junior developers", "2025-04-07", "COMPLETED");
		addTask("Client Presentation", "Prepare slides and demo for client pitch", "2025-04-15", "PENDING");
		addTask("Update documentation", "Revise internal API documentation for the new release", "2025-04-12",
				"IN_PROGRESS");
		addTask("Fix bug", "Resolve login error", "2025-04-08", "IN_PROGRESS");
		addTask("Call HR", "Ask about leave policy", "2025-04-09", "PENDING");
		addTask("Write doc", "Update API notes", "2025-04-10", "COMPLETED");
		addTask("Team sync", "Daily stand-up meet", "2025-04-06", "PENDING");
		addTask("Push code", "Commit changes to Git", "2025-04-07", "IN_PROGRESS");

	}

	@Override
	public void addTask(String taskName, String description, String taskDate, String status) {

		LocalDate ld = LocalDate.parse(taskDate);
		StatusEnum s = StatusEnum.valueOf(status.toUpperCase());
		Task t = new Task(taskName, description, ld, s);
		taskMap.put(t.getTaskId(), t);
	}

	@Override
	public String deleteTask(int taskId) {

		Task t = taskMap.get(taskId);
		taskMap.remove(taskId);

		return t + " deleted Succesfully!!!";
	}

	@Override
	public String updateTaskStatus(int taskId, String status) {

		StatusEnum s = StatusEnum.valueOf(status.toUpperCase());
		Task t = taskMap.get(taskId);
		t.setStatus(s);

		return "Status Updated Succesfuly to :" + t.getStatus();
	}

	@Override
	public void displayAllPendingTasks() {
		taskMap.values().stream().filter(t -> t.getStatus() == StatusEnum.valueOf("PENDING"))
				.forEach(t -> System.out.println(t));
	}

	@Override
	public void displayAllTaskForToday() {
		taskMap.values().stream().filter(t -> t.getTaskDate() == LocalDate.now()).forEach(t -> System.out.println(t));
	}

	@Override
	public void displayAllSortedByDate() {
		taskMap.values().stream().sorted((t1, t2) -> t1.getTaskDate().compareTo(t2.getTaskDate()))
				.forEach(t -> System.out.println(t));
	}
}
