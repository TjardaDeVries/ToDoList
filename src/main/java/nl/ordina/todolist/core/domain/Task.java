package nl.ordina.todolist.core.domain;

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
        return String.format("desciprtion=%s;priority=%s;dueDate=%s", description, priority, dueDate);
    }
}
