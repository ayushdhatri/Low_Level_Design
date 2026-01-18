package Low_Level_Design.Problems.LibraryManagementSystem.models;

import Low_Level_Design.Problems.LibraryManagementSystem.state.ItemState;

public class BookCopy{
    private final String id;
    private final LibraryItem item;
    private ItemState currentState;

    public BookCopy(String id, LibraryItem item){
        this.id = id;
        this.item = item;
        item.addCopy(this);
    }
    public void borrow(Member member){
       //need bookCopyObject
    }
    public void returnItem(){
        // just we need bookCopy objecdt
    }

    public void markLost(){
        // just we need bookCopy object and mark as lost


    }
    public String getId(){
        return this.id;
    }
    public void setState(ItemState itemState){
        this.currentState = itemState;
    }

}