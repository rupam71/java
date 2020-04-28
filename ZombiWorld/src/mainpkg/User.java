package mainpkg;

abstract public class User {
    public int id;            
    public String name, email, mobile;     

    public User() {
    }

    
    public User(int id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    abstract public void setInfo();       
    abstract public void showInfo(); 
}
