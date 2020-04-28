package mainpkg;

import java.util.Random;
import java.util.Scanner;

public class MainClass {
   
    public static void main(String[] args) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        //int[] oneD = new int[](10);
        int[] oneD = new int[10];
        int i,j, row, col;
        for(i=0;i<oneD.length;i++)
            oneD[i] = r.nextInt(100);
        System.out.print("The oneD array is: ");
        for(i=0;i<oneD.length;i++)
            System.out.print(oneD[i]+" ");
        
        //Real interpretation & it works everytime
        int[][] twoD;
        System.out.print("How many rows? ");
        row = s.nextInt();
        twoD = new int[row][];
        for(i=0; i<twoD.length; i++){
            System.out.print("How many columns in row "+(i+1)+"? ");
            col = s.nextInt();
            twoD[i] = new int[col];
        }
        
        //Convenient equivalent, BUT may not work on ALL IDEs
        //depends on JDK version
        //int[][] twoD = new int[3][4];

        System.out.println("\n\nThe twoD array is: ");
        for(i=0;i<twoD.length;i++){
            for(j=0;j<twoD[i].length;j++){
                twoD[i][j] = r.nextInt(10);
                System.out.print(twoD[i][j]+" ");
            }
            System.out.println();
        }
            
            
        
    }
    
}
