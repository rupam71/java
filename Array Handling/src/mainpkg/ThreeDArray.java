package test;
public class Test {    
    public static void main(String[] args) {        
        int[][][] arr3 = new int[2][][];
        
        arr3[0] = new int[4][];
        
        arr3[0][0] = new int[]{10,20};
        arr3[0][1] = new int[]{30,40};
        arr3[0][2] = new int[]{50,60};
        arr3[0][3] = new int[]{70,80,90};
        
        arr3[1] = new int[1][];
        
        arr3[1][0] = new int[]{1,2,3,4};
        
        for(int i=0; i<arr3.length; i++){
            for(int j=0; j<arr3[i].length; j++){
                for(int k=0; k<arr3[i][j].length; k++){
                    System.out.print(arr3[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println("\n");
        }
    }    
}
