package facade;

import model.*;
import service.LibraryService;
import factory.BookFactory;
import chain.*;
import observer.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryFacade implements Subject {
    private LibraryService library = LibraryService.getInstance();
    private List<Observer> observers = new ArrayList<>();
    private ApprovalHandler chain;

    public LibraryFacade() {

        ApprovalHandler librarian = new LibrarianHandler();
        ApprovalHandler manager = new ManagerHandler();
        librarian.setNext(manager);
        this.chain = librarian;
    }

    public void addBook(String type, String title) {
        Book book = BookFactory.createBook(type, title);
        library.addBook(book);
        System.out.println("Book added to library: " + book.getTitle());
    }

    public void borrowBook(String title, User user) {
        Book book = library.findBook(title);
        if (book != null && book.isAvailable()) {
            if (chain.handleRequest(book, user)) {
                book.borrowBook(user);
            } else {
                System.out.println("Borrowing request denied for user: " + user.getName());
            }
        } else {
            System.out.println("Book not found or unavailable: " + title);
        }
    }

    public void returnBook(String title) {
        Book book = library.findBook(title);
        if (book != null) {
            book.returnBook();
            notifyObservers(book);
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
