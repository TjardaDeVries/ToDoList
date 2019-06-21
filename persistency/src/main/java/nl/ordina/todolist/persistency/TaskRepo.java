package nl.ordina.todolist.persistency;

import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskRepo implements TaskGateway {

    private List<Task> tasks = new ArrayList<>();

    private String file = "/Users/tjardadevries/projects/uwv/lessons/lesson_03/archive/data/tasks";

    public TaskRepo() {
        if (fileExists()) {
            loadTasks();
        }
    }

    public void save(final Task task) {
        tasks.add(task);
        saveTasks();
    }

    public List<Task> retrieveAll() {
        return tasks;
    }

    private void loadTasks() {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            tasks = (List<Task>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveTasks() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(tasks);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean fileExists() {
        File tmpDir = new File(file);
        System.out.println("Persisted tasks found!");
        return tmpDir.exists();
    }

}
