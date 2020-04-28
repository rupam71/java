package mainpkg;

import java.io.Serializable;

public class Ticket implements Serializable{
    private int passengerId, busNo, noOfSeat;
    private  String seatNumber;

    public Ticket() {
    }

    public Ticket( int busNo, int passengerId, int noOfSeat, String seatNumber) {
        this.passengerId = passengerId;
        this.busNo = busNo;
        this.noOfSeat = noOfSeat;
        this.seatNumber = seatNumber;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public int getBusNo() {
        return busNo;
    }

    public int getNoOfSeat() {
        return noOfSeat;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    
    @Override
    public String toString() {
        return "Bus No: "+busNo+", Passenger No: "+passengerId+", No Of Seat: "+noOfSeat+", Seat Number: "+seatNumber ;
                }
    
    
    
}
