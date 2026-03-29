package decorator;

import model.Book;

public class PremiumBookDecorator extends BookDecorator {
    public PremiumBookDecorator(Book book) {
        super(book);
    }

    @Override
    public String getTitle() {
        return "[Premium] " + decoratedBook.getTitle();
    }
}
