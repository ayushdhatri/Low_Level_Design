


package Low_Level_Design.Problems.LibraryManagementSystem.state;

import Low_Level_Design.Problems.LibraryManagementSystem.models.BookCopy;
import Low_Level_Design.Problems.LibraryManagementSystem.models.Member;

public interface ItemState {
    public void borrow(BookCopy bookCopy, Member member);
    public void returnItem(BookCopy bookCopy);
    public void markLost(BookCopy bookCopy);
}