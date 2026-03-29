package chain;

import model.Book;
import model.User;

public interface ApprovalHandler {
    void setNext(ApprovalHandler next);
    boolean handleRequest(Book book, User user);
}
