package model;

public abstract class Book implements BookInterface {
    protected String title;
    protected boolean isAvailable = true;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public boolean isAvailable() { return isAvailable; }

    @Override
    public void borrowBook(User user) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(user.getName() + " borrowed: " + title);
        } else {
            System.out.println(title + " is currently unavailable.");
        }
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }
}
