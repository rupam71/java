package user;

import java.util.Scanner;

public class Student extends Person{
    int sId; float cgpa; String major;
    public Student(){
        super();
        sId=0; cgpa = 0.0f; major = "TBA";
    }
    public Student(int sId, float cgpa, String major){
        this.sId=sId; 
        this.cgpa=cgpa;
        this.major = major;
    }
    public Student(String name, String dob, String bg, String gender, int sId, float cgpa, String major){
        super(name, dob, bg, gender);
        this.sId=sId; 
        this.cgpa=cgpa;
        this.major = major;
    }
    public void setStudentInfo(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Student ID: "); sId=s.nextInt();
        s.nextLine(); setPersonInfo();
        System.out.print("Enter Student major: "); major=s.nextLine();
        System.out.print("Enter Student CGPA: "); cgpa=s.nextFloat();
    }
    public void showStudentInfo(){
        System.out.print("ID: "+sId+", ");
        showPersonInfo();
        System.out.print(", Major: "+major+", CGPA: "+cgpa);
    }
    public int getSId(){ return sId; }
    public float getCgpa(){ return cgpa; }
    public String getMajor(){ return major; }
    public void setSId(int id){ sId = id;}
    public void setCgpa(float cgpa){ this.cgpa = cgpa;}
    public void setMajor(String major){ this.major = major;}
    
    @Override
    public int getId() {return sId;}
    @Override
    public void showInfo() {
        System.out.print("ID: "+sId+", ");
        showPersonInfo();
        System.out.print(", Major: "+major+", CGPA: "+cgpa);
    }
    @Override
    public void applyForLeave() {
    System.out.println("Common Code to Apply For Leave...");
    }
    public void calcCgpa(){
        System.out.println("CGPA is calculated for "+name);
    }
}
