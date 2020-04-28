package mainpkg;

import java.io.Serializable;

public class Emp implements Serializable{
    private String joinType;
    
    private String name, gender, joinDate, contractNo;
    private int id;
    private float salary;
    
    public Emp() {}

    public Emp(int id, String name, String gender,  String joinDate, String contractNo, float salary, String joinType) {
        //super(joinDate, contractNo, salary, id, name, gender);
        this.joinType = joinType;
        
        this.joinDate = joinDate;
        this.contractNo = contractNo;
        this.salary = salary;
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    @Override
    public String toString() {
        return "Id: "+id+", Name: "+name+", Gender: "+gender+", Join Date: "+joinDate+", Salary: "+salary+", Contract No: "+contractNo+", Join Type: "+joinType;
    
    }
    
}

