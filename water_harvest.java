import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class calc{

public int trap(int[] height) {
    int result = 0;
 
    if(height==null || height.length<=2)
        return result;
 
    int left[] = new int[height.length];
    int right[]= new int[height.length];
    int max = height[0];
    left[0] = height[0];
    for(int i=1; i<height.length; i++){
        if(height[i]<max){
            left[i]=max;
        }else{
            left[i]=height[i];
            max = height[i];
        }
    }
 
    //scan from right to left
    max = height[height.length-1];
    right[height.length-1]=height[height.length-1];
    for(int i=height.length-2; i>=0; i--){
        if(height[i]<max){
            right[i]=max;
        }else{
            right[i]=height[i];
            max = height[i];
        }
    }
 
    //calculate totoal
    for(int i=0; i<height.length; i++){
        result+= Math.min(left[i],right[i])-height[i];
    }
 
    return result;
}
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
         calc x=new calc();
        int n=sc.nextInt();
                int[] height = new int[n];
        for(int i=0;i<n;i++)
        {
                height[i]=sc.nextInt();
                
            }
        int waterTrapped=x.trap(height);
        System.out.println(waterTrapped);     
    }
}
