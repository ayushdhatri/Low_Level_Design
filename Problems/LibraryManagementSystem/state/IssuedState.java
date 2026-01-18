package Low_Level_Design.Problems.LibraryManagementSystem.state;

import Low_Level_Design.Problems.LibraryManagementSystem.models.BookCopy;


public class IssuedState implements ItemState{

    @Override
    public void borrow(BookCopy bookCopy, Member member) {
        // TODO Auto-generated method stub
        throw new IllegalStateException("This book is already booked!");
    }

    @Override
    public void returnItem(BookCopy bookCopy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnItem'");
    }

    @Override
    public void markLost(BookCopy bookCopy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'markLost'");
    }



}