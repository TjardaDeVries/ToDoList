package nl.ordina.todolist;

import nl.ordina.todolist.delivery.Presenter;

public class App {
    public static void main(final String[] args) {
        Presenter presenter = new Presenter();
        presenter.start();
    }
}
