/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.app.attempt;

import java.util.ArrayList;

/**
 *
 * @author bilalzahid
 */
public class FileHandler {
    private static final String FILE_NAME = "tasks.txt";

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    tasks.add(new Task(parts[0], parts[1]));
                }
            }
        } catch (java.io.IOException e) {
            
        }
        return tasks;
    }

    public static void saveTasks(ArrayList<Task> tasks) {
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.getTitle() + "|" + task.getDescription());
                writer.newLine();
            }
        } catch (java.io.IOException e) {
            
        }
    }
}

