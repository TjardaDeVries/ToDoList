package nl.ordina.todolist;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.usecases.ListTasksBoundary;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

//@SpringComponent
//@UIScope
public class TaskListLayout extends VerticalLayout {

    @Autowired
    ListTasksBoundary listTasks;

    Grid<Task> grid = new Grid<>();

    @PostConstruct
    void init() {
        this.setTasks(listTasks.execute());
    }

    private void setTasks(final List<Task> tasks) {
        grid.setItems(tasks);
        addComponent(grid);
    }
}
