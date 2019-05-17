package nl.ordina.todolist.core.usecases;

public interface CreateTaskBoundary {

    void execute(final String description, final String priority, final String dueDate);

}
