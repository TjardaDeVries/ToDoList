package nl.ordina.todolist.core.usecases;

import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;

import java.util.List;

public class ListTasks implements ListTasksBoundary {

    final private TaskGateway taskGateway;

    public ListTasks(final TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    public List<Task> execute() {
        return taskGateway.retrieveAll();
    }
}
