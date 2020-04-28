package user;

import java.util.Scanner;


    abstract public class Person {
    protected String name, dob, bg, gender;
    
    public Person(){
        name = dob = bg = gender = "TBA";
    }
    
    public String getName(){ return name; }
    public String getDob(){ return dob; }
    public String getBg(){ return bg; }
    public String getGender(){ return gender; }
    
    public void setName(String name) { this.name = name; }
    public void setDob(String dob) { this.dob = dob; }
    public void setBg(String bg) { this.bg = bg; }
    public void setGender(String gender) { this.gender = gender; }
    
    public Person(String name, String dob, String bg, String gender){
        this.name = name;
        this.dob = dob;
        this.bg = bg;
        this.gender = gender;
    }
    
    public void setPersonInfo(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Name: "); name = s.nextLine();
        System.out.print("Enter Date Of Birth: "); dob = s.nextLine();
        System.out.print("Enter Blood Group: "); bg = s.nextLine();
        System.out.print("Enter Gender (Male / Female): "); gender = s.nextLine();
    }
    
    public void showPersonInfo(){
        System.out.print("Name: "+name+" , Date Of Birth: "+dob+" , Blood Group: "+bg+" , Gender: "+gender);
    }
    
    public void perticipateInFireDrill(){
        System.out.println("Perticipating in fire drill");
    }
    abstract public int getId();
    abstract public void showInfo();
    abstract public void applyForLeave();
}
