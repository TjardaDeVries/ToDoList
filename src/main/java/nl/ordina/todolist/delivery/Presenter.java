package nl.ordina.todolist.delivery;

import nl.ordina.todolist.core.usecases.CreateTaskBoundary;
import nl.ordina.todolist.core.usecases.ListTasksBoundary;

import java.io.Console;
import java.util.Date;

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
                    System.exit(0);
                case "create":
                    createTaskBoundary.execute("description", "1", new Date());
                    break;
                case "listAll":
                    listTasksBoundary.execute().forEach(System.out::println);
                    break;
                default:
                    System.out.println(command);
            }
        }
    }
}
