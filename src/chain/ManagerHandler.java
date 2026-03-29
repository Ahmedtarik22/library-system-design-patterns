package chain;

import model.Book;
import model.User;

public class ManagerHandler implements ApprovalHandler {
    private ApprovalHandler next;

    @Override
    public void setNext(ApprovalHandler next) {
        this.next = next;
    }

    @Override
    public boolean handleRequest(Book book, User user) {
        if (user.isPremium() || book.getClass().getSimpleName().equals("HistoricalBook")) {
            System.out.println("Manager approved borrowing for: " + user.getName());
            return true;
        } else if (next != null) {
            return next.handleRequest(book, user);
        }
        return false;
    }
}
