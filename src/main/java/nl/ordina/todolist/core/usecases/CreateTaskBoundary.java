package nl.ordina.todolist.core.usecases;

import java.util.Date;

public interface CreateTaskBoundary {

    void execute(final String description, final String priority, final Date dueDate);

}
