import java.io.*;
import java.util.*;

class Circuit{
    

public int canCompleteCircuit(int[] drink, int[] energy,int n) 
{
    int sumRemaining = 0; // track current remaining
    int total = 0; // track total remaining
    int start = 0; 
 
    for (int i = 0; i < n; i++) {
        int remaining = energy[i] - drink[i];
        if (sumRemaining >= 0) { 
            sumRemaining += remaining;
        //otherwise, reset start index to be current
        } else {
            sumRemaining = remaining;
            start = i;
        }
        total += remaining;
    }
 
    if (total >= 0){
        return start;
    }else{
        return -1;
    }
}
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int index;
        Scanner sc=new Scanner(System.in); 
        Circuit x=new Circuit();
        int n=sc.nextInt(); 
        int[] drink = new int[n];  
        int[] energy = new int[n];  
        for(int i=0; i<n; i++)  
    {  
    //reading array elements from the user   
    energy[i]=sc.nextInt();  
    }  
        for(int i=0; i<n; i++)  
    {  
    //reading array elements from the user   
    drink[i]=sc.nextInt();  
    }
     index=x.canCompleteCircuit(drink,energy,n);
        System.out.println(index);
        
    }
}
