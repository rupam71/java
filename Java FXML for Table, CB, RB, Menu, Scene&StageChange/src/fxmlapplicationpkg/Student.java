package fxmlapplicationpkg;

import java.io.Serializable;

public class Student implements Serializable{  
    int id;  
    String name;
    float cgpa;
    public Student(int id, String name, float f) {  
        this.id = id;  
        this.name = name;
        cgpa = f;
    }
    public void display()
    {
        System.out.println("Id="+id+", Name="+name+", Cgpa="+cgpa);
    }
    @Override
    public String toString(){
        return "Id="+id+", Name="+name+", Cgpa="+cgpa;
    }
} 