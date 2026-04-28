/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thproject;

import java.util.ArrayList;

public class Taskmanger {

    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task t) throws InvalidTaskException {

        if (t.name == null || t.name.isEmpty()) {
            throw new InvalidTaskException("Invalid task");
        }

        tasks.add(t);
    }

    public void deleteTask(int id) {
        tasks.removeIf(t -> t.id == id);
    }

    public void showTasks() {
        for (Task t : tasks) {
            t.displayTask();
        }
    }

}