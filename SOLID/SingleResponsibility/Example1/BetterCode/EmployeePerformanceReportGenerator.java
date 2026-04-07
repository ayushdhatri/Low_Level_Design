package Low_Level_Design.SOLID.SingleResponsibility.Example1.BetterCode;

public class EmployeePerformanceReportGenerator {
    public void printPerformanceReport(Employee e){
        // code to print performance report
        System.out.println("Performance report of employee + " + e.getEmployeeName());
    }
    
}
