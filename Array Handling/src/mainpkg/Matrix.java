/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarrays;

/**
 *
 * @author HP
 */
public class Matrix {
    OneDArray[][] arrays;

    public Matrix() {
    }

    public Matrix(int r, int c) {
        arrays = new OneDArray[r][c];
        for(int i=0; i<arrays.length; i++){
            for(int j=0; j<arrays[i].length; j++){
                arrays[i][j] = new OneDArray();
                arrays[i][j].getArray();
            }
        }
    }
    
    public Matrix(int r, int c, int len, int upper) {
        arrays = new OneDArray[r][c];
        for(int i=0; i<arrays.length; i++){
            for(int j=0; j<arrays[i].length; j++){
                arrays[i][j] = new OneDArray();
                arrays[i][j].setArray(len,upper);
                len++;
            }
        }
    }
    
    public void showMatrix(){
        for(int i=0; i<arrays.length; i++){
            for(int j=0; j<arrays[i].length; j++){
                arrays[i][j].showArray();
            }
            System.out.println("");
        }
    }
    
    public Matrix merge(Matrix m){
        Matrix n = new Matrix();
        n.arrays = new OneDArray[this.arrays.length][this.arrays[0].length];
        for(int i=0; i<n.arrays.length; i++){
            for(int j=0; j<n.arrays[0].length; j++){                
                n.arrays[i][j] = new OneDArray();
                n.arrays[i][j].mergeArray(this.arrays[i][j], m.arrays[i][j]);
            }
        }
        return n;
    } 
}
