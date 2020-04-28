/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author USER
 */
public class CourierServiceUser extends User{
    ArrayList<Parcel> pList = new ArrayList<Parcel>();
    
    
    private String type;
    
    public CourierServiceUser() {
    }
    
    public void sendParcel(String parcelName, String from, String to, String date, float weight, int customerId, String customerName){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("AllParcel.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);                               
            }
     
            
            
            int id = parcelId();
            
            
     Parcel p;
            p = new Parcel( parcelName, id, from, to, date, weight, customerId, customerName);
            oos.writeObject(p);
            System.out.println("write done");
            System.out.println(p);
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
    
    
    
    public int parcelId(){
        int count = 0;
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("AllParcel.bin");
            if(!f.exists())
                return 0;
            else{
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                try{
                    Parcel emp;
                    while(true){
                        emp = (Parcel)ois.readObject();
                        count++;
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        catch(Exception e){
        }//end of outer catch
        finally{ // outer finally
            if(ois != null) {
                try {
                ois.close();
                } catch (IOException ex) {
   //                 Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return count+1;
    }
    
    public String parcelHistory( int cusId){
        String str = "";
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("AllParcel.bin");
            if(!f.exists())
                System.out.println("File Does Not Exists!!");
            else {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                try{
                    Parcel a;
                    while(true){
                        a = (Parcel)ois.readObject();
                       if(a.getCustomerId() == cusId){
                           str += (a.toString()+" \n");
                       }
                    }
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
        } catch (IOException ex){
            System.out.println(ex);
        }
        
        finally{
            if(ois != null)
            try{
                 ois.close();
            } catch (IOException ex){
            System.out.println(ex);
        }
        }
        
        return str;
    }
}
