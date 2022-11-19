import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Coins {
        public int calc(int[] ratings) {
            
            int ans = 0;
            int n = ratings.length;
            int[] coin = new int[n];
            
            for(int i=ratings.length-1;i>0;i--){
                if(ratings[i-1]>ratings[i]){
                    coin[i-1] = coin[i]+1;
                }
            }
            
            for(int i=0;i<ratings.length-1;i++)
            {
                if(ratings[i]<ratings[i+1] && coin[i]>=coin[i+1])
                {
                    coin[i+1] = coin[i]+1;
                }
                ans+=coin[i];
            }
            
            return n+ans+coin[n-1];
        }
}

public class Solution {

    public static void main(String[] args) {
        Coins x=new Coins();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
                int[] ratings = new int[n];
        for(int i=0;i<n;i++)
        {
                ratings[i]=sc.nextInt();                
            }
        
        int min=x.calc(ratings);
        System.out.println(min);
    }
}
