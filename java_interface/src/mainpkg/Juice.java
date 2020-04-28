package mainpkg;

public class Juice extends Liquid implements Drinkable{
    private String company, flavour;
    private int amount, price;

    public Juice(String name, String color, String company, String flavour, int amount, int price) {
        super(name, color);
        this.company = company;
        this.flavour = flavour;
        this.amount = amount;
        this.price = price;
    }
    
    @Override
    public void konoHoiCoiAche() {
        dheleDei();
        System.out.println("Kintu "+amount+" ta "+name+ " Dhele Dile "+ company +" Hoi Choi Korbe.");
    }

    @Override
    public void openBottle() {
        System.out.println(name + "Open!!!");
    }

    @Override
    public void drink() {
        System.out.println(flavour+" flavour is Good!!");
    }
    
}
