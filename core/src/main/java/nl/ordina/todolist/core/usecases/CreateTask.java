package nl.ordina.todolist.core.usecases;

import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CreateTask implements CreateTaskBoundary {

    private final TaskGateway taskGateway;

    @Autowired
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

        Task task = new Task();
        task.setDescription(description);
        task.setPriority(priority);
        task.setDueDate(date);
        taskGateway.save(task);
        return 0;
    }

}
