package nl.ordina.todolist;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*", name = "ToDoListServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = ToDoListUI.class, productionMode = false)
public class ToDoListServlet extends VaadinServlet {}
