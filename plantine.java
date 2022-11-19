import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class plantation {
    public boolean canPlant(int[] bananas, int n) {
        if (bananas.length == 0 || n <= 0) 
            return true;
        int m = bananas.length;
        for (int i = 0; i < m; i++) {
            if (bananas[i] == 1) continue;
            int lastVal = i == 0 ? 0 : bananas[i-1];
            int nextval = i == m-1? 0: bananas[i+1];
            if (lastVal == 0 && nextval == 0) {
                bananas[i] = 1;
                n--;
            }
            if (n <= 0) return true;
        }
            
        return false;
    }
}


public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        plantation x=new plantation();
        int m=sc.nextInt();
         int[] bannanas = new int[m];    
        for (int i = 0; i < m; i++)  
        {  
            bannanas[i]=sc.nextInt();
        }
        int n=sc.nextInt();
        boolean possible=x.canPlant(bannanas,n);
        if(possible==true)
        {
            System.out.println("TRUE");
    }
             else
        {
            System.out.println("FALSE");
    }      
    }  
   }
