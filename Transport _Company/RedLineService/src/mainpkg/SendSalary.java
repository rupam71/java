/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author USER
 */
public class SendSalary {
    private SimpleStringProperty name, type;
    private int id;
    private float salary;

    public SendSalary(int id, String name, String type,  float salary) {
        this.name = new SimpleStringProperty(name);;
        this.type = new SimpleStringProperty(type);;
        this.id = id;
        this.salary = salary;
    }
    
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setType(String type) {
        this.type = new SimpleStringProperty(type);
    }
    
    public String getName() {
        return name.get();
    }

    public String getType() {
        return type.get();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    
}
