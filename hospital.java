import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Sick{
public static boolean isSafe(int[][] v, int i, int j) {
  int n = v.length;
  int m = v[0].length;
  return (i >= 0 && j >= 0 && i < n && j < m);
}
public static int numberOfDays(int[][] v) {
  int days = 2;
  boolean flag = false;
  int n = v.length;
  int m = v[0].length;
  while (true) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (v[i][j] == days) {
          if (isSafe(v, i + 1, j) && v[i + 1][j] == 1) {
            v[i + 1][j] = v[i][j] + 1;
            flag = true;
          }
          if (isSafe(v, i, j + 1) && v[i][j + 1] == 1) {
            v[i][j + 1] = v[i][j] + 1;
            flag = true;
          }
          if (isSafe(v, i - 1, j) && v[i - 1][j] == 1) {
            v[i - 1][j] =v[i][j] + 1;
            flag = true;
          }
          if (isSafe(v, i, j - 1) && v[i][j - 1] == 1) {
            v[i][j - 1] = v[i][j] + 1;
            flag = true;
          }
        }
      }
    }
    if (flag == false) {
      break;
    }
    flag = false;
    days++;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (v[i][j] == 1) {
        days = -1;
      }
    }
  }
  return days == -1 ? days : days - 2;
}
}
  class Solution{
       public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
           Sick x=new Sick();
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] v = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                v[i][j]=sc.nextInt();
                
            }
        }
 
        int patientSick=x.numberOfDays(v);
        System.out.println(patientSick);
    }
}
