package adapter;

import model.Book;
import factory.BookFactory;

public class BookAdapter {
    public static Book fromCsv(ExternalBookData externalData) {
        String[] parts = externalData.getCsvData().split(",");
        String title = parts[0];
        String type = parts[1];
        return BookFactory.createBook(type, title);
    }
}
