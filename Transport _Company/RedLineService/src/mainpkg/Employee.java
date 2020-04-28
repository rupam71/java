package mainpkg;

abstract public class Employee extends User{
    protected String joinDate, contractNo;
    protected float salary;

    public Employee() {}

    public Employee(String joinDate, String contractNo, float salary, int id, String name, String gender) {
        super(id, name, gender);
        this.joinDate = joinDate;
        this.contractNo = contractNo;
        this.salary = salary;
        
    }
    
    abstract public void setEmployeeInfo();
    abstract public void showEmployeeInfo();
    abstract public void showNotice();
}
