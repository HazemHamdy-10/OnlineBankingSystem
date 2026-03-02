package org.example;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String title) {
        tasks.add(new Task(nextId++, title));
        System.out.println("Task added successfully!");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted (if existed).");
    }

    public void completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markCompleted();
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}