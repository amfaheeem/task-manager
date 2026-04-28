/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thproject;

/**
 *
 * @author amfah
 */
public class main {

    public static void main(String[] args) {

        try {

            Taskmanger manager = new Taskmanger();
            Databasemanger db= new Databasemanger();

            Task t1 = new Task(1,"try to get out of aast","graduate");
            Task t2 = new Task(2,"Gym","Workout till amoooot");

            manager.addTask(t1);
            manager.addTask(t2);

            db.saveTask(t1);

            manager.showTasks();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
