package nl.ordina.todolist.core.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    final private String description;

    final private String priority;

    final private Date dueDate;

    public Task(final String description, final String priority, final Date dueDate) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%s (%s) is due on %s", description, priority, dateFormat.format(dueDate));
    }
}
