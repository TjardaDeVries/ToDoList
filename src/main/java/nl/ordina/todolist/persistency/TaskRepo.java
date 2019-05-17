package nl.ordina.todolist.persistency;

import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;

import java.util.ArrayList;
import java.util.List;

public class TaskRepo implements TaskGateway {

    private List<Task> tasks = new ArrayList<>();

    public void save(Task task) {
        tasks.add(task);
    }

    public List<Task> retrieveAll() {
        return tasks;
    }
}
