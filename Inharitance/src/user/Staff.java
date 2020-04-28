package user;

import java.util.Scanner;

public class Staff extends Employee{
    private int overTimeHour, overTimeRate;
    public Staff(){
        super();
        overTimeHour = overTimeRate = 0;
    }
    public Staff(int eId, String name, String dob, String bg, String gender, String desig, float salary, int overTimeHour, int overTimeRate){
        super(eId, name, dob, bg, gender, desig, salary);
        this.overTimeHour = overTimeHour;
        this.overTimeRate = overTimeRate;
    }
    
    public int getOverTimeHour(){ return overTimeHour;}
    public int getOverTimeRate(){ return overTimeRate;}
    public void setOverTimeHour(int time){ overTimeHour = time;}
    public void setOverTimeRate(int rate){ overTimeRate= rate;}

    public void setStaffInfo(){
        Scanner s = new Scanner(System.in);
        System.out.println();
        setEmpInfo();
        System.out.print("Total Over Time (Hour): "); overTimeHour = s.nextInt();
        System.out.print("Over Time Rate (Taka): "); overTimeRate = s.nextInt();
    }
    public void showStaffInfo(){
        showEmpInfo();
        System.out.print("Overtime Amount: "+(overTimeHour*overTimeRate));
    }
    
    @Override
    public void showEmployeeInfo() {
        showEmpInfo();
        System.out.print("Overtime Amount: "+(overTimeHour*overTimeRate));    
    }

    @Override
    public void tractAttendance() {
        System.out.println("Customized code to track staff attendance...");
    }

    @Override
    public int getId() {
        return eId;
    }

    @Override
    public void showInfo() {
        System.out.println();
        showEmpInfo();
        System.out.print("Overtime Amount: "+(overTimeHour*overTimeRate));    
    }
}
