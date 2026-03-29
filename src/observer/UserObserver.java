package observer;

import model.Book;

public class UserObserver implements Observer {
    private String name;

    public UserObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Book book) {
        System.out.println("Notification to " + name + ": Book '" + book.getTitle() + "' is now available!");
    }
}
