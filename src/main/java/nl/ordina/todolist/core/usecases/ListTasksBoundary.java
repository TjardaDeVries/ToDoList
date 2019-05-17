package nl.ordina.todolist.core.usecases;

import nl.ordina.todolist.core.domain.Task;

import java.util.List;

public interface ListTasksBoundary {

    List<Task> execute();

}
