package nl.ordina.todolist.core.usecases;

import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateTask implements CreateTaskBoundary {

    private final TaskGateway taskGateway;

    public CreateTask(final TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    public void execute(final String description, final String priority, final String dueDate) {
        //TODO Validate input parameters
        Task task = null;
        try {
            task = new Task(description, priority, new SimpleDateFormat("dd/MM/yyyy").parse(dueDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskGateway.save(task);
    }

}
