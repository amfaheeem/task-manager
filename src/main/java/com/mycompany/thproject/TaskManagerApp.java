package com.mycompany.thproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {

    private Databasemanger db;
    private Taskmanger manager;
    private ObservableList<String> taskDisplayList;
    private ListView<String> listView;
    private java.util.List<Task> tasks;

    @Override
    public void start(Stage stage) {
        db = new Databasemanger();
        manager = new Taskmanger();

        TextField nameField = new TextField();
        nameField.setPromptText("Task name");

        TextField descField = new TextField();
        descField.setPromptText("Description");

        Button addBtn = new Button("Add Task");
        Button deleteBtn = new Button("Delete Task");

        HBox inputRow = new HBox(10, nameField, descField, addBtn, deleteBtn);
        inputRow.setPadding(new Insets(10));

        taskDisplayList = FXCollections.observableArrayList();
        listView = new ListView<>(taskDisplayList);

        refreshList();

        addBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String desc = descField.getText().trim();
            if (name.isEmpty()) return;

            int nextId = tasks.isEmpty() ? 1 : tasks.stream().mapToInt(Task::getId).max().getAsInt() + 1;
            Task t = new Task(nextId, name, desc);
            try {
                manager.addTask(t);
                db.saveTask(t);
                nameField.clear();
                descField.clear();
                refreshList();
            } catch (InvalidTaskException ex) {
                System.out.println(ex.getMessage());
            }
        });

        deleteBtn.setOnAction(e -> {
            int selected = listView.getSelectionModel().getSelectedIndex();
            if (selected < 0) return;
            Task t = tasks.get(selected);
            db.deleteTask(t.getId());
            manager.deleteTask(t.getId());
            refreshList();
        });

        VBox root = new VBox(10, inputRow, listView);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Task Manager");
        stage.setScene(scene);
        stage.show();
    }

    private void refreshList() {
        tasks = db.getAllTasks();
        taskDisplayList.clear();
        for (Task t : tasks) {
            taskDisplayList.add(t.getId() + " - " + t.getName() + " - " + t.getDescription());
        }
    }
}
