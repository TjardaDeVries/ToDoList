package nl.ordina.todolist.core.usecases;

public interface CreateTaskBoundary {

    /**
     *
     * @param description The description of the Task to be created
     * @param priority The priority of the Task to be created. Must be 1, 2, or 3
     * @param dueDate The dueDate of the Task to be created. Must be formatted 'dd/MM/yyyy'
     * @return This method returns a return code: 0 = success, 200 = dueDate could not be parsed
     */
    Integer execute(final String description, final String priority, final String dueDate);

}
