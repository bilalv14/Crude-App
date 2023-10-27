/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.app.attempt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bilalzahid
 */
public class TaskManager {

    private ArrayList<Task> tasks;
    private Scanner scanner;

    public TaskManager() {
        tasks = FileHandler.loadTasks();
        scanner = new Scanner(System.in);
    }
public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add a new task");
            System.out.println("2. List all tasks");
            System.out.println("3. Update a task");
            System.out.println("4. Delete a task");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addTask();
                    break;

                case 2:
                    listTasks();
                    break;

                case 3:
                    updateTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task task = new Task(title, description);
        tasks.add(task);
        FileHandler.saveTasks(tasks);
    }

    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". Title: " + task.getTitle() + ", Description: " + task.getDescription());
            }
        }
    }

    private void updateTask() {
        listTasks();
        System.out.print("Enter the task number to update: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            System.out.print("Enter updated title: ");
            String updatedTitle = scanner.nextLine();
            System.out.print("Enter updated description: ");
            String updatedDescription = scanner.nextLine();
            Task updatedTask = new Task(updatedTitle, updatedDescription);
            tasks.set(taskNumber - 1, updatedTask);
            FileHandler.saveTasks(tasks);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private void deleteTask() {
        listTasks();
        System.out.print("Enter the task number to delete: ");
        int taskToDelete = scanner.nextInt();
        scanner.nextLine();
        if (taskToDelete >= 1 && taskToDelete <= tasks.size()) {
            tasks.remove(taskToDelete - 1);
            FileHandler.saveTasks(tasks);
        } else {
            System.out.println("Invalid task number.");
        }
    }
}