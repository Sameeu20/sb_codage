import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class coins {
  public int arrangeCoins(int n) {
    long left = 1;
    long right = n;
    while (left <= right) {
      long mid = (left + right) / 2;
      long sum = mid * (mid + 1) / 2;
      if (sum == n) {
        return (int) mid;
      } else if (sum > n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (int) right;
  }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x=new Scanner(System.in);
        coins c=new coins();
        int n=x.nextInt();
        int build=c.arrangeCoins(n);
        System.out.println(build);
        
    }
}
