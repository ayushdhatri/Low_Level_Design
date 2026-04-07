package Low_Level_Design.SOLID.SingleResponsibility.Example1.BetterCode;
import java.util.*;
public class Employee {
    private int id;
    private String name;
    private String address;
    public Employee(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public int getEmployeeId(){
        return this.id;
    }
    public String getEmployeeName(){
        return this.name;
    }
    public String getEmployeeAddress(){
        return this.address;
    }
    
    public void setEmployeeAddress(String address){
        this.address = address;
    }


    public static void main(String[] args){

    }    
}
