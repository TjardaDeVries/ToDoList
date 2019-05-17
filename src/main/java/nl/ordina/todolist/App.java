package nl.ordina.todolist;

import nl.ordina.todolist.delivery.Presenter;

public class App {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.start();
    }
}
