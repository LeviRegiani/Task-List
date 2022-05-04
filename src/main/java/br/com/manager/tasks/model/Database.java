package br.com.manager.tasks.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
	private static List<Task> listTasks = new ArrayList<Task>();
	
	static {
			Task task = new Task();
			task.setDateCreation(new Date());
			task.setId(1);
			task.setStartDate(new Date());
			task.setTitle("Hello");
			task.setDescription("Yet to fill!");
			task.setFinalDate(new Date(2022, 6, 20));
			listTasks.add(task);
	}
	
	public List<Task> getTasks() {
		return Database.listTasks;
	}
}
