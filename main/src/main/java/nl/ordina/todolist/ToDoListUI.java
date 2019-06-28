package nl.ordina.todolist;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.domain.TaskGateway;
import nl.ordina.todolist.core.usecases.ListTasks;
import nl.ordina.todolist.core.usecases.ListTasksBoundary;
import nl.ordina.todolist.persistency.TaskRepo;

import java.util.List;

public class ToDoListUI extends UI {

    private final ListTasksBoundary listTasksUseCase;
    private Grid<Task> grid = new Grid<>(Task.class);

    public ToDoListUI(final ListTasksBoundary listTasksUseCase) {
        this.listTasksUseCase = listTasksUseCase;
    }

    @Override
    protected void init(final VaadinRequest vaadinRequest) {

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        verticalLayout.setMargin(true);

        List<Task> tasks = listTasksUseCase.execute();

        grid.setColumns("description", "priority", "dueDate");
        grid.setItems(tasks);

        verticalLayout.addComponent(grid);

        setContent(verticalLayout);
    }
}