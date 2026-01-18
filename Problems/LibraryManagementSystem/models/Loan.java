package Low_Level_Design.Problems.LibraryManagementSystem.models;

import java.time.LocalDate;

public class Loan {
    private final BookCopy bookCopy;
    private final Member member;
    private final LocalDate checkOutDate;

    public Loan(BookCopy bookCopy, Member member){
        this.bookCopy = bookCopy;
        this.member = member;
        this.checkOutDate = LocalDate.now();
    }

    public BookCopy getCopy(){
        return this.bookCopy;
    }
    public Member getMember(){
        return member;
    }

}