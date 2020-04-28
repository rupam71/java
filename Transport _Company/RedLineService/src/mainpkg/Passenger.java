package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Passenger extends User{
    private String customerType;

    public Passenger() {}
    
    public void ticketBooking(int busId, int passengerId, int noOfSeat){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("BusInfo.bin");
            if(!f.exists())
                System.out.println("File Does Not Exists!!");
            else {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                try{
                    Bus a;
                    while(true){
                        a = (Bus)ois.readObject();
                        if(a.getBusId() == busId){
                            if(a.getAvailableSeat()>noOfSeat){
                                a.bookingBusTicket(busId, passengerId, noOfSeat);
                            }
                        }
                        
           //             outputTextArea.appendText(a.toString()+"\n");
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
    }
}
