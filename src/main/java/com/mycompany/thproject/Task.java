/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thproject;

/**
 *
 * @author amfah
 */
public class Task {
    String name;
    boolean completed;
    int id;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Task(int id, String title, String description){
        this.id = id;
        this.name= title;
        this.description = description;
        this.completed = false;
    }
    public void markDone(){
        completed = true;
    }
public void displayTask(){
        System.out.println(id + " - " + name + " - " + description);
    }

}
