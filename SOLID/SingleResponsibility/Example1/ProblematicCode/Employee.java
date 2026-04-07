package Low_Level_Design.SOLID.SingleResponsibility.Example1.ProblematicCode;

import java.util.*;

/*
 - Issue with this code :
 - This single class is responsible for multiple things such as fetching, updating , computing salary, and print performanc report
 - but at the same time I think that everything is there at single place so centralization is there in code
 - UpdateEmployee Data is fine to keep in this class, as we have the details of employee which can fetched from database using fetchEmployeeData
 - So two classes update and fetch can exist in the class but other two classes should not exist
 - In case of computeSalary if lets say tommorow strategy changes then we need to change this part
 - in case of updateEmployeeData() if data storage way change then I need to change this class as well
 - in case of printPerformanceReport(); if report format changes then we might need to change the code
 - We can see that there are so many reason to change this class so it is not following SingleResponsibility and this should give you smell of bad code
 - Single Responsibility says that there should be only one reason to change a piece of code


 */
public class Employee {
    private int id;// Employee Id
    private String name; // Employee Name
    private String address;// Employee Address

    public void printPerformanceReport(){
        // code to print performance report
        System.out.println("Performance report of employee " + name);
    }
    public double computeSalary(){
        // Code to compute salary
        return 1000.0;
    }
    public void updateEmployeeData(){
        // Code to update employee data
        System.out.println("Employee data updated successfully");
    }
    public void fetchEmployeeData(){
        // code to fetch employee data
        System.out.println("Employee data fetched successfully");
    }
    public static void main(String[] args){ 


    }
}