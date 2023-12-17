//import java.util.*;

public class P2J1 {
    public static long fallingPower(int n, int k){
        
        long output = 1;

        for(int i = 0; i < k; i++){
            output *= n;
            n--; 
        }

        return output;
    }

    public static int[] everyOther(int[] arr){
        int newArray[] = new int [(arr.length + 1)/2 ]; 
        int c = 0;

        for(int i = 0; i < arr.length; i+= 2){
            newArray[c] = arr[i];
            c++;
        }
        
        return newArray;
    }

    public static int[][] createZigZag(int rows, int cols, int start){
        int[][] newArray = new int[rows][cols];
        int i,j;
       
        for(i = 0; i < rows; i++){
            if(i % 2 == 0){
                j=0;
                while( j < cols){
                    newArray[i][j] = start;
                    start+= 1;
                    j++;
                }
            }
            else{
                j = cols-1;
                while(j >= 0){
                    newArray[i][j]=start;
                    start+=1;
                    j--;
                }
            }
           
        }
        return newArray;
    }

    public static int countInversions(int[] arr){
        int count = 0;

        for(int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
