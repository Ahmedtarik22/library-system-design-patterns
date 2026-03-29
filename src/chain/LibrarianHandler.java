package chain;

import model.Book;
import model.User;

public class LibrarianHandler implements ApprovalHandler {
    private ApprovalHandler next;

    @Override
    public void setNext(ApprovalHandler next) {
        this.next = next;
    }

    @Override
    public boolean handleRequest(Book book, User user) {

        if (!book.getClass().getSimpleName().equals("HistoricalBook") && !user.isPremium()) {
            System.out.println("Librarian approved borrowing for user: " + user.getName());
            return true;
        } else if (next != null) {
            return next.handleRequest(book, user);
        }
        return false;
    }
}
