package nl.ordina.todolist;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import nl.ordina.todolist.core.domain.Task;
import nl.ordina.todolist.core.usecases.ListTasksBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@SpringUI
public class ToDoListUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    public static class Servlet extends SpringVaadinServlet {
    }

    // this will load WEB-INF/applicationContext.xml
    @WebListener
    public static class MyListener extends ContextLoaderListener {
    }

    @Configuration
    @EnableVaadin
    public static class MyConfiguration {
    }

    private VerticalLayout root;

//    @Autowired
//    TaskListLayout taskListLayout;

    Grid<Task> grid = new Grid<>();

    @Autowired
    ListTasksBoundary listTasks;


    @Override
    protected void init(final VaadinRequest vaadinRequest) {
        setupLayout();
        setupTaskList();
    }


    private void setupLayout() {
        root = new VerticalLayout();
        root.setSpacing(true);
        root.setMargin(true);
        setContent(root);
    }

    private void setupTaskList() {
//        root.addComponent(taskListLayout);
        grid.setItems(listTasks.execute());
        root.addComponent(grid);
    }


}