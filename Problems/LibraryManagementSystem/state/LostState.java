package Low_Level_Design.Problems.LibraryManagementSystem.state;

import Low_Level_Design.Problems.LibraryManagementSystem.models.BookCopy;


public class LostState implements ItemState{

    @Override
    public void borrow(BookCopy bookCopy, Member member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrow'");
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


