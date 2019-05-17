package nl.ordina.todolist.core.usecases;

import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;

import java.util.Date;

public class CreateTask implements CreateTaskBoundary {

    private final TaskGateway taskGateway;

    public CreateTask(final TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    public void execute(final String description, final String priority, final Date dueDate) {
        //TODO Validate input parameters
        Task task = new Task(description, priority, dueDate);
        taskGateway.save(task);
    }

}
