package Low_Level_Design.Problems.LibraryManagementSystem.state;

import Low_Level_Design.Problems.LibraryManagementSystem.TransactionService;
import Low_Level_Design.Problems.LibraryManagementSystem.models.BookCopy;
import Low_Level_Design.Problems.LibraryManagementSystem.models.Member;

public class AvailableState implements ItemState{

    @Override
    public void borrow(BookCopy bookCopy, Member member) {
        // you can borrow the book and mark the state as issued state
        TransactionService.getInstance().createLoan(bookCopy, member);
        bookCopy.setState(new IssuedState());
    
    }

    @Override
    public void returnItem(BookCopy bookCopy) {
        throw new IllegalStateException("BookCopy is already availalbe...Cannot Return it...");
       
    }

    @Override
    public void markLost(BookCopy bookCopy) {
       bookCopy.setState(new LostState());
    }
    
}