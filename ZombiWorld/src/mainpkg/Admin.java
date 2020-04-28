package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends User{
    private String designation;
    private float salary;

//    public Admin(int id, String name, String email, String mobile, String designation, float salary) {
//        super(id, name, email, mobile);
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.mobile = mobile;
//        this.designation = designation;
//        this.salary = salary;
//    }

    public Admin(String designation, float salary, int id, String name, String email, String mobile) {
        super(id, name, email, mobile);
        this.designation = designation;
        this.salary = salary;
    }
    
    
    
    
    public static void createNewStudent(int id, String name, String email,String mobile , float cgpa, String dept ){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("student.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);                               
            }
            Student s = new Student(cgpa, dept, id, name, email, mobile);
            System.out.println(s);
             oos.writeObject(s);
            System.out.println("write done");
        } catch(Exception ex){
            System.out.println(ex);
        }
        finally{
            if(oos != null) try {
                oos.close();
                fos.close();
            } catch (IOException ex) { System.out.println(ex);}
        }
    }
    
    @Override
    public void setInfo() {
        System.out.println("Set Adminy Info");
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter ID: "); id = s.nextInt();
        s.nextLine();
        System.out.print("Enter Name: "); name = s.nextLine();
        System.out.print("Enter Email: "); email = s.nextLine();
        System.out.print("Enter Mobile: "); mobile = s.nextLine();
        System.out.print("Enter Designation: "); designation = s.nextLine();
        System.out.print("Enter Salary: "); salary = s.nextFloat();
    }

    @Override
    public void showInfo() {
        System.out.println("ID : "+id+", Name : "+name+", email : "+email+", mobile : "+mobile+", Salary : "+salary+", Designation : "+designation+";");
    }
    
}
