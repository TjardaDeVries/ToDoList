package nl.ordina.todolist.delivery;

import nl.ordina.todolist.core.usecases.CreateTaskBoundary;
import nl.ordina.todolist.core.usecases.ListTasksBoundary;

import java.io.Console;

public class Presenter {

    final private CreateTaskBoundary createTaskBoundary;

    final private ListTasksBoundary listTasksBoundary;

    public Presenter(final CreateTaskBoundary createTaskBoundary, final ListTasksBoundary listTasksBoundary) {
        this.createTaskBoundary = createTaskBoundary;
        this.listTasksBoundary = listTasksBoundary;
    }

    public void start() {
        while (true) {
            Console console = System.console();
            String command = console.readLine("tdl>: ");
            switch (command) {
                case "quit":
                    exectueQuitCommand();
                case "create":
                    executeCreateCommand(console);
                    break;
                case "listAll":
                    executeListAllCommand();
                    break;
                default:
                    System.out.println("unknown command");
            }
        }
    }

    private void executeListAllCommand() {
        listTasksBoundary.execute().forEach(System.out::println);
    }

    private void exectueQuitCommand() {
        System.exit(0);
    }

    private void executeCreateCommand(final Console console) {
        final String description = console.readLine("description?: ");
        final String priority = console.readLine("priority?: ");
        final String dueDate = console.readLine("dueDate?: ");
        createTaskBoundary.execute(description, priority, dueDate);
    }
}
