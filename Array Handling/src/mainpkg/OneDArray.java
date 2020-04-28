/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class OneDArray {
    int[] values;
    float average;
    
    public void getArray(){
        Scanner s = new Scanner(System.in);
        System.out.print("How many numbers: ");
        int l = s.nextInt();
        values = new int[l];
        System.out.print("Enter values: ");
        for(int i=0; i<l; i++){
            values[i] = s.nextInt();
        }
    }
    
    public void setArray(int len, int upper){
        values = new int[len];
        Random r = new Random();
        for(int i=0; i<len; i++){
            values[i] = r.nextInt(upper);
        }
    }
    
    public void mergeArray(OneDArray a1, OneDArray a2){
        values = new int[a1.values.length+a2.values.length];
        for(int i=0; i<a1.values.length; i++){
            values[i] = a1.values[i];
        }
        for(int i=0; i<a2.values.length; i++){
            values[i+a1.values.length] = a2.values[i];
        }
    }
    
    public void showArray(){
        System.out.print("{");
        for(int i=0; i<values.length; i++){
            System.out.print(values[i]);
            if(i<values.length-1)System.out.print(",");
        }
        System.out.print("} ");
        printAverage();
    }
    
    public void printAverage(){
        int sum=0;
        for(int i=0; i<values.length; i++){
            sum+=values[i];
        }
        average=(float)sum/(float)values.length;
        System.out.print("Avg: "+average+"  ");
        System.out.print("     ");
    }
}
