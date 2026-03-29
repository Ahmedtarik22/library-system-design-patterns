package factory;

import model.*;

public class BookFactory {
    public static Book createBook(String type, String title) {
        switch (type.toLowerCase()) {
            case "physical":
                return new PhysicalBook(title);
            case "ebook":
                return new EBook(title);
            case "historical":
                return new HistoricalBook(title);
            default:
                throw new IllegalArgumentException("Unknown book type: " + type);
        }
    }
}
