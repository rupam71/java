package mainpkg;

public class SoftDrinks extends Liquid implements Drinkable, Carbonatable{
    private String company, bottle;
    private int  price;

    public SoftDrinks(String company, String bottle, int price, String name, String color) {
        super(name, color);
        this.company = company;
        this.bottle = bottle;
        this.price = price;
    }
    
    
    @Override
    public void konoHoiCoiAche() {
        dheleDei();
        System.out.println("Kintu "+company+" Hoi Coi Korbe.");
    }

    @Override
    public void openBottle() {
        System.out.println(name + "Open!!!");
    }

    @Override
    public void drink() {
        System.out.println(" flavour is Good!!");
    }

    @Override
    public void mildCarbonatable() {
        System.out.println("Mild Carbonatable");
    }

    @Override
    public void moderateCarbonatable() {
        System.out.println("Moderate Carbonatable");
    }

    @Override
    public void strongCarbonatable() {
        System.out.println("Strong Carbonatable");
    }
    
}
