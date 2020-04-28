package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Bus implements Serializable{
    ArrayList<String> seatList =  new ArrayList<String>();
    private int busId, totalSeat, passengerId, availableSeat;
    private String busName, couch, from, to;

    public Bus() {
    }

    public Bus(int busId, String busName,  String couch, String from, String to, int totalSeat) {
        this.busId = busId;
        this.totalSeat = totalSeat;
        this.busName = busName;
        this.couch = couch;
        this.from = from;
        this.to = to;
        this.totalSeat = totalSeat;
        for(int i=0; i<totalSeat; i++){
            seatList.add("Not Booked");
        }
        availableSeat();
    }

    public ArrayList<String> getSeatList() {
        return seatList;
    }

    public int getBusId() {
        return busId;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getBusName() {
        return busName;
    }

    public String getCouch() {
        return couch;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    
    public void bookingBusTicket(int busId, int passengerId, int noOfSeat){
        availableSeat -= noOfSeat;
        
        int n = noOfSeat; String seatNumber="";
        
        for(int i=0; i<seatList.size(); i++){
            if(seatList.get(i) == "Not Booked"){
                if(n != 0){
                    seatList.add(i, "Booked");
                    int num = i;
                    seatNumber += ("num  ") ;
                    n--;
                }
            }  
        }
        
        
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("AllTicket.bin");
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
            Ticket s = new Ticket(busId, passengerId, noOfSeat,seatNumber);
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
    
    public void availableSeat(){
        int available=0;
        for(int i=0; i<seatList.size(); i++){
            if(seatList.get(i) == "Not Booked") available++;
        }
        availableSeat = available;
    }
    
    @Override
    public String toString() {
        return  "Bus No: "+busId+", Name: "+busName+", Couch: "+couch+", From: "+from+", To: "+to+", TotalSeat: "+totalSeat+", Available Seat: "+availableSeat ;
                }
    
    
    
    
    
    
}
