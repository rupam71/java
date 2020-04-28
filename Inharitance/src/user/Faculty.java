package user;

import java.util.ArrayList;
import java.util.Scanner;

public class Faculty extends Employee{
    ArrayList<String> pubList;
    public Faculty(){
        super();
        pubList = new ArrayList<String>();
    }
    public Faculty(int eId, String name, String dob, String bg, String gender, String desig, float salary, int n){
        super(eId, name, dob, bg, gender, desig, salary);
        Scanner s = new Scanner(System.in);
        pubList = new ArrayList<String>();
        String str;
        for(int i=0; i<n; i++){
            System.out.print("Enter Publication Title: ");
            str = s.nextLine();
            pubList.add(str);
        }
    }
    public void setFacultyInfo(){
        pubList = new ArrayList<String>();
        Scanner s = new Scanner(System.in);
        setEmpInfo();
        int n; String str;
        System.out.print("How Many Publication: "); n = s.nextInt();
        s.nextLine();
        for(int i=0; i<n; i++){
            System.out.print("Enter Publication Title: ");
            str = s.nextLine();
            pubList.add(str);
        }
    }
    public ArrayList<String> getPubList(){ return pubList; }
    public void setPubList(ArrayList<String> pubList){ this.pubList = pubList;}
    
    public void showFacultyInfo(){
        showEmpInfo();
        System.out.println();
        for(String title: pubList){ 
            System.out.println(title); 
        }
    }
    
    @Override
    public void showEmployeeInfo() {
        showEmpInfo();
        System.out.println();
        for(String title: pubList){ 
            System.out.println(title); 
        }    
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
        System.out.println();
        for(String title: pubList){ 
            System.out.println(title); 
        }      
    }
    
}
