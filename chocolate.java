import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class faircandyswap {
 public int[] Swap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : A) {
            sumA += num;
            set.add(num);
        }
        
        for (int num : B) {
            sumB += num;
        }
        
        int diff = (sumA - sumB)/2;
        
        int[] ans = new int[2];
        for (int num : B) {
            if (set.contains(num + diff)) {
                ans[0] = num + diff;
                ans[1] = num;
                break;
            }
        }
            
        return ans;
    }

}
 class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        faircandyswap c=new faircandyswap();
        int m=sc.nextInt();
        
        
        int[] A = new int[m];
        for(int i=0;i<m;i++)
        {
                A[i]=sc.nextInt();
                
            }
        int n=sc.nextInt();
        int[] B = new int[n];
        
        
                for(int i=0;i<n;i++)
        {
                B[i]=sc.nextInt();
                
            }
        int[] exchange = c.Swap(A,B);
            System.out.print(exchange[0]);
        System.out.print(" ");
            System.out.print(exchange[1]);
    }
}
