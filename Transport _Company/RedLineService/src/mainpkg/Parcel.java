package mainpkg;

import java.io.Serializable;

public class Parcel implements Serializable{
    private int customerId, parcelNo;
    private String parcelName, from, to, date, customerName;
    private float weight;

    public Parcel() {}

    public Parcel(String parcelName, int parcelNo, String from, String to, String date, float weight, int customerId, String customerName) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.parcelNo = parcelNo;
        this.parcelName = parcelName;
        this.from = from;
        this.to = to;
        this.date = date;
        this.weight = weight;
    }

    public int getCustomerId() {
        return customerId;
    }
    
    public String getParcelName() {
        return parcelName;
    }
    
    public int getParcelNo() {
        return parcelNo;
    }

    public String getFromPlace(){return from;}
    
    public String getFrom() {
        return from;
    }

    public float getWeight() {
        return weight;
    }
    
    
    
    public String toString() {
        return "Parcel Name: "+parcelName+", Parcel No: "+parcelNo+", Parcel From: "+from+", Parcel To: "+to+", Parcel Sending Date: "+date+", Parcel Weight: "+weight+", Parcel Sender: "+customerName+", Parcel Sender No: "+customerId;
    }
}
