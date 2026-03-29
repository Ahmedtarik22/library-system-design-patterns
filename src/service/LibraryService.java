package service;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private static LibraryService instance;
    private List<Book> books = new ArrayList<>();

    private LibraryService() {}

    public static synchronized LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
