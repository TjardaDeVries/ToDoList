package nl.ordina.todolist.delivery;

import java.io.Console;

public class Presenter {

    public void start() {
        while (true) {
            Console console = System.console();
            String command = console.readLine("tdl>: ");
            switch (command) {
                case "quit":
                    System.exit(0);
                default:
                    System.out.println(command);
            }
        }
    }
}
