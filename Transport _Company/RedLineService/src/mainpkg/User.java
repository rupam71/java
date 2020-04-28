package mainpkg;

import java.util.Scanner;

abstract public class User {
    protected String name, gender; 
    protected int id;

    public User() {
    }

    public User(int id, String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
//    public static User verifyLogin(String s1, String s2){
//        System.out.println("Done");
//    }
    
    public void setInfo(){
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter Id: ");   id = s.nextInt();
        s.nextLine();
        System.out.print("Enter Name: ");   name = s.nextLine();
        System.out.print("Enter Gender: ");   gender = s.nextLine();
    }
    
    public void showInfo(){
        System.out.println("Id: "+id+", Name: "+name+", Gender: "+gender);
    }
}
