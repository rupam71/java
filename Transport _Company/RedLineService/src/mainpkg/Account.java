package mainpkg;

import java.io.Serializable;

public class Account implements Serializable{
    private int currentAmount, transectionNumber;
    private String text;

    public Account() {
    }

    public Account(int currentAmount, int transectionNumber, String text) {
        this.currentAmount = currentAmount;
        this.transectionNumber = transectionNumber;
        this.text = text;
    }
    
    public Account(int transectionNumber, String text) {
     //   this.currentAmount = currentAmount;
        this.transectionNumber = transectionNumber;
        this.text = text;
    }
    
    public void diposit(int amount){
        System.out.println("Money Entry Total "+amount);
        currentAmount += amount;
        System.out.println("Total Current Money Right Now : "+currentAmount);
    }
    
    public void withdraw(int amount){
        System.out.println("Money Withdraw Total "+amount);
        currentAmount -= amount;
        System.out.println("Total Current Money Right Now : "+currentAmount);
    }

    @Override
    public String toString() {
        return "Current Money: "+currentAmount+", Transection No: "+transectionNumber+", Text: "+text;
    }
    
    
}
