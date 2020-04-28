package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Admin extends User{
    String joinType, contractNo;

    public Admin() {}

    public Admin(int id, String name, String gender, String contractNo) {
        super(id, name, gender);
        this.joinType = "Admin";
        this.contractNo = contractNo;
    }
    
    public void setEmployeeInfo(int id, String name, String gender,  String joinDate, String contractNo, float salary, String joinType){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("AllEmployeeInformation.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);                               
            }
            // int id, String name, String gender,  String joinDate, String contractNo, float salary
            
              //      2, "Abdul Rahim", "Male", "01-01-2017", "01987654321", 11000
            Emp s = new Emp(id, name, gender, joinDate, contractNo, salary, joinType);
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
    
    public void createNewBus(int busId, String busName,  String couch, String from, String to, int totalSeat){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("BusInfo.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);                               
            }
     
            
            
     //       int id = parcelId();
            
            
     Bus b;
            b = new Bus( busId, busName, couch, from, to, totalSeat);
            oos.writeObject(b);
            System.out.println("write done");
            System.out.println(b);
        } catch(Exception ex){
            System.out.println(ex);
            System.out.println(ex);
        }
        finally{
            if(oos != null) try {
                oos.close();
                fos.close();
            } catch (IOException ex) { System.out.println(ex);}
        }
    }
    
}


