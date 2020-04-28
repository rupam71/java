package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student extends User implements Serializable  {
    private int id;            
    private String name, email, mobile;
    private float cgpa;
    private String dept;


    public Student(float cgpa, String dept, int id, String name, String email, String mobile) {
//        super(id, name, email, mobile);
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.cgpa = cgpa;
        this.dept = dept;
    }
    
    public void registerACourse(int Courseid, int studentId, String semester ,int year, int section){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("regCourses.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);                               
            }
            RegisteredCourse s = new RegisteredCourse(Courseid, studentId, semester, year, section);
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
    
    int getStudentID() { return id;}
    
//    public ObservableList<RegisteredCourse> getRegCourseList( ) {
//        ObservableList<RegisteredCourse> stud = FXCollections.ObservableArrayList();
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//             File f = new File("regCourses.bin");
//            if(!f.exists())
//                System.out.println("File Does Not Exists!!");
//            
//            else {
//                fis = new FileInputStream(f);
//                ois = new ObjectInputStream(fis);
//                
//                 try{
////                    Student s;
//                    while(true){
//        RegisteredCourse reg = (RegisteredCourse) ois.readObject();
//        stud.add(new RegisteredCourse(Courseid, studentId, semester, year, section));
//        }
//            } catch (Exception ex){
//                    System.out.println(ex);
//                }
//            }
//            
//        } catch (IOException ex) {
////            Logger.getLogger(FXMLMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//        
//        finally{
//            if(ois != null)
//            try{
//                 ois.close();
//            } catch (IOException ex){
//            System.out.println(ex);
//        }
//        }
//    } 
    
    @Override
    public void setInfo() {
        System.out.println("Set Student Info");
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter ID: "); id = s.nextInt();
        s.nextLine();
        System.out.print("Enter Name: "); name = s.nextLine();
        System.out.print("Enter Email: "); email = s.nextLine();
        System.out.print("Enter Mobile: "); mobile = s.nextLine();
        System.out.print("Enter dept: "); dept = s.nextLine();
        System.out.print("Enter CGPA: "); cgpa = s.nextFloat();
    }

    @Override
    public void showInfo() {
        display();
    }

    public void display(){
        System.out.println("ID : "+id+", Name : "+name+", email : "+email+", mobile : "+mobile+", CGPA : "+cgpa+", dept : "+dept+";");
    }

    @Override
    public String toString() {
        return "ID : "+id+", Name : "+name+", email : "+email+", mobile : "+mobile+", CGPA : "+cgpa+", dept : "+dept+";\n";
        }
    
    
    
}
