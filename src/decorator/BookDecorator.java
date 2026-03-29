package decorator;

import model.Book;
import model.User;

public abstract class BookDecorator extends Book {
    protected Book decoratedBook;

    public BookDecorator(Book book) {
        super(book.getTitle());
        this.decoratedBook = book;
    }

    @Override
    public boolean isAvailable() {
        return decoratedBook.isAvailable();
    }

    @Override
    public void borrowBook(User user) {
        decoratedBook.borrowBook(user);
    }

    @Override
    public void returnBook() {
        decoratedBook.returnBook();
    }
}
