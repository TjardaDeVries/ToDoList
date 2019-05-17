package nl.ordina.todolist;

import java.io.Console;

public class App {
    public static void main(String[] args) {
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
