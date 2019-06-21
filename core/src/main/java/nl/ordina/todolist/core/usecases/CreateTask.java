package nl.ordina.todolist.core.usecases;

import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTask implements CreateTaskBoundary {

    private final TaskGateway taskGateway;

    public CreateTask(final TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    public Integer execute(final String description, final String priority, final String dueDate) {
        //TODO Validate input parameters

        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);
        } catch (ParseException e) {
            return 200;
        }

        Task task = new Task(description, priority, date);
        taskGateway.save(task);
        return 0;
    }

}
