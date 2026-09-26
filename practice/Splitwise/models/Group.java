package Low_Level_Design.practice.Splitwise.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Group {
    private final String groupId;

    private String groupName;

    private List<User> users;

    private List<Expense> expenses;

    // every group has list of users
    // and each user, has list of user they owe and owed
    // I have one question here
    // can we keep like two simple thing how much a user owed, and how much owe.
    // but then in that case, how will I get to know who to pay, or who will pay me
    
    private final String adminId;

    public Group(String groupName, String adminId, List<User> groupUsers){
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.adminId = adminId;
        this.users = groupUsers;
        this.expenses = new ArrayList<>();
    }

    public String getGroupId(){
        return this.groupId;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public List<User> getUsers(){
        return Collections.unmodifiableList(this.users);
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }

    public void removeExpense(Expense expense){
        this.expenses.remove(expense);
    }

    public String getAdminId(){
        return this.adminId;
    }

    public List<Expense> getAllExpense(){
        return this.expenses;
    }



    
}
