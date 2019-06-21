package nl.ordina.todolist.core.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private String description;

    private String priority;

    private Date dueDate;

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%s (%s) is due on %s", description, priority, dateFormat.format(dueDate));
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setPriority(final String priority) {
        this.priority = priority;
    }

    public void setDueDate(final Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
