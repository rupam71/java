package mainpkg;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner s = new Scanner (System.in); 
       int choice = 0; 
       do{
        System.out.println("\n\nEnter [1] to add Juice ");
        System.out.println("Enter [2] to add Soft Drinks ");
        System.out.println("Enter [3] to open Juice Bottle ");
        System.out.println("Enter [4] to open Soft Drinks Bottle ");
        System.out.println("Enter [5] to check Soft Drinks Mild Carbonatable ");
        System.out.println("Enter [6] to check Soft Drinks Moderate Carbonatable ");
        System.out.println("Enter [7] to check Soft Drinks Strong Carbonatable");
        System.out.println("Enter [8] to Check Juice Hoi Coi ");
        System.out.println("Enter [9] to Check Soft Drinks Hoi Coi  ");
        System.out.println("Enter [10] to Exit ");
        System.out.print("Enter Your Choice : ");
       choice = s.nextInt();
       switch(choice)
        {
           case 1:
               // name, color, company, flavour, amount, price
               Juice frutika = new Juice("Frutica", "red", "Pran", "Mango", 250, 30);
            break;
            
           case 2:
               
            break;
            
           case 3:
               Juice fruto = new Juice("Frutica", "red", "Pran", "Mango", 250, 30);
               fruto.openBottle();
               fruto.drink();
            break;
            
           case 4:
               
            break;
            
           case 5:
               
            break;
            
           case 6:
               
            break;
            
           case 7:
               
            break;
            
           case 8:
               
            break;
            
           case 9:
               
            break;
            
       }
       }while (choice != 10);
    }
    
}
