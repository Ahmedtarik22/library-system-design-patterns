import model.Book;
import model.User;
import service.LibraryService;
import factory.BookFactory;
import decorator.*;
import chain.*;
import facade.LibraryFacade;
import adapter.*;
import observer.*;

public class Main {
    public static void main(String[] args) {

        LibraryFacade facade = new LibraryFacade();

        facade.attach(new UserObserver("Alice"));
        facade.attach(new UserObserver("Bob"));

        facade.addBook("physical", "The Great Gatsby");
        facade.addBook("ebook", "Clean Code");
        facade.addBook("historical", "Ancient Rome");

        ExternalBookData externalData = new ExternalBookData("Design Patterns,physical");
        Book adaptedBook = BookAdapter.fromCsv(externalData);
        LibraryService.getInstance().addBook(adaptedBook);
        System.out.println("Adapted legacy book: " + adaptedBook.getTitle());

        Book book = LibraryService.getInstance().findBook("Clean Code");
        if (book != null) {
            Book premiumEBook = new PremiumEBookDecorator(book);
            System.out.println("Decorated Title: " + premiumEBook.getTitle());
        }

        User regularUser = new User("John", false);
        User premiumUser = new User("Jane", true);

        System.out.println("\n--- Borrowing Scenarios ---");
        facade.borrowBook("The Great Gatsby", regularUser); 
        facade.borrowBook("Ancient Rome", regularUser);     
        facade.borrowBook("Ancient Rome", premiumUser);     

        System.out.println("\n--- Returning Scenarios (Observer) ---");
        facade.returnBook("The Great Gatsby"); 
    }
}
