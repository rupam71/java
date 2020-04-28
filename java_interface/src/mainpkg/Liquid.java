package mainpkg;

abstract public class Liquid {
    protected String name, color;

    public Liquid() {}
    public Liquid(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public void dheleDei(){
        System.out.println("Taheri Cacche "+ name +" Dhele dite.");
    }
    abstract public void konoHoiCoiAche();
}
