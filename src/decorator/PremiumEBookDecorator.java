package decorator;

import model.Book;

public class PremiumEBookDecorator extends BookDecorator {
    public PremiumEBookDecorator(Book book) {
        super(book);
    }

    @Override
    public String getTitle() {
        return "[Premium E-Book] " + decoratedBook.getTitle();
    }
}
