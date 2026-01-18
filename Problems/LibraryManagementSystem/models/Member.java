package Low_Level_Design.Problems.LibraryManagementSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();
    public Member(String id, String name){
        this.id = id;
        this.name = name;
    }

    public void addLoan(Loan loan){
        loans.add(loan);
    }

    public void removeLoan(Loan loan){
        loans.remove(loan);
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public List<Loan> getLoans(){
        return loans;
    }

    
}