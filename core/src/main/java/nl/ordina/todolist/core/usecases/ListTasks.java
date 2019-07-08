package nl.ordina.todolist.core.usecases;

import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListTasks implements ListTasksBoundary {

    final private TaskGateway taskGateway;

    @Autowired
    public ListTasks(final TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    public List<Task> execute() {
        return taskGateway.retrieveAll();
    }
}
