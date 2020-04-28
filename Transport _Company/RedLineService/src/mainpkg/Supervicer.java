package mainpkg;

import java.io.Serializable;
import java.util.Scanner;

public class Supervicer extends Employee implements Reportable, Serializable{
    private String joinType;
    
    private String name, gender, joinDate, contractNo;
    private int id;
    private float salary;
    
    public Supervicer() {}

    public Supervicer(int id, String name, String gender,  String joinDate, String contractNo, float salary) {
        super(joinDate, contractNo, salary, id, name, gender);
        this.joinType = "Bus Supervicer";
    }
    
    
    
    @Override
    public void setEmployeeInfo() {
        setInfo();
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter Salary: ");   salary = s.nextInt();
        s.nextLine();
        System.out.print("Enter Join Date: ");   joinDate = s.nextLine();
        System.out.print("Enter Contract No: ");   contractNo = s.nextLine();
    }

    @Override
    public void showEmployeeInfo() {
        showInfo();
        System.out.println("Join Date: "+joinDate+", Salary: "+salary+", Contract No: "+contractNo+", Join Type: "+joinType);
    }

    @Override
    public void showNotice() {
        
    }

    @Override
    public void createReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Id: "+id+", Name: "+name+", Gender: "+gender+", Join Date: "+joinDate+", Salary: "+salary+", Contract No: "+contractNo+", Join Type: "+joinType;
    
    }
    
    
    
}
