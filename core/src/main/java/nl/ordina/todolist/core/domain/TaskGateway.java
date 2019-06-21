package nl.ordina.todolist.core.domain;

import java.util.List;

public interface TaskGateway {

    void save(final Task task);

    List<Task> retrieveAll();

}
