package Low_Level_Design.Problems.LibraryManagementSystem.models;

import java.util.ArrayList;
import java.util.List;

public abstract class LibraryItem{
    private final String id;
    private final String title;
    protected final List<BookCopy> copies = new ArrayList();
    public LibraryItem(String id, String title){
        this.id = id;
        this.title = title;
    }

    public void addCopy(BookCopy copy){
        this.copies.add(copy);
    }
    public BookCopy getAvailablecopy(){
        return copies.stream()
        .filter(BookCopy::isAvailable)
        .findFirst()
        .orElse(null);
    }
    //Getter
    public String getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public List<BookCopy> getCopies(){
        return this.copies;
    }
    public abstract String getAuthorOrPublisher();
    public long getAvailableCopyCount(){
        return copies.stream()
        .filter(BookCopy::isAvailable).count();
    }
    
    

}