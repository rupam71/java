package user;

import java.util.Scanner;

 abstract public class Employee extends Person {
    protected int eId; String desig; float salary;
    public Employee(){
        super();
        eId =0; desig = "TBA"; salary=0.0f;
    }

    public int geteId() { return eId; }
    public String getDesig() { return desig; }
    public float getSalary() { return salary; }
    public void seteId(int eId) { this.eId = eId; }
    public void setDesig(String desig) { this.desig = desig; }
    public void seteId(float salary) { this.salary = salary; }
    
    public Employee(int eId, String name, String dob, String bg, String gender, String desig, float salary){
        super(name,dob,bg,gender);
        this.eId = eId; 
        this.desig = desig;
        this.salary = salary;
    }
    
    public void setEmpInfo(){
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter ID: "); eId = s.nextInt();
        s.nextLine();
        setPersonInfo();
        System.out.print("Enter Designation: "); desig = s.nextLine();
        System.out.print("Enter Salary: "); salary = s.nextFloat();
    }
    
    public void showEmpInfo(){
        System.out.println();
        System.out.print("ID: "+eId+" , ");
        showPersonInfo();
        System.out.print(" , Designation: "+desig+" , Salary: "+salary);
    }
    
    @Override
    public void applyForLeave(){
        System.out.println("Common Code to Apply For Leave...");
    }
    public void sendReportToSupervisor(){
        System.out.println("Report sent to supervisor by "+name);
    }
    abstract public void showEmployeeInfo();
    abstract public void tractAttendance();
}
