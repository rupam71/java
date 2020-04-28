package mainpkg;

public class AccountOfficer extends User{
    private String officerType;
    Account account;

    public AccountOfficer() {
    }

    public AccountOfficer(int id, String name, String gender) {
        super(id, name, gender);
        this.officerType = "Account Officer";
        this.account = account;
    }
    
    public void totalRevenueReport(){
        
    }
}
