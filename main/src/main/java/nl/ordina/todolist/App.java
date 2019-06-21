package nl.ordina.todolist;

import nl.ordina.todolist.core.domain.TaskGateway;
import nl.ordina.todolist.core.usecases.CreateTask;
import nl.ordina.todolist.core.usecases.CreateTaskBoundary;
import nl.ordina.todolist.core.usecases.ListTasks;
import nl.ordina.todolist.core.usecases.ListTasksBoundary;
import nl.ordina.todolist.delivery.Presenter;
import nl.ordina.todolist.persistency.TaskRepo;

public class App {
    public static void main(final String[] args) {
        TaskGateway taskGateway = new TaskRepo();
        CreateTaskBoundary createTaskBoundary = new CreateTask(taskGateway);
        ListTasksBoundary listTasksBoundary = new ListTasks(taskGateway);
        Presenter presenter = new Presenter(createTaskBoundary, listTasksBoundary);
        presenter.start();
    }
}
