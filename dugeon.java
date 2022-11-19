import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Health {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 1;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] hp = new int[m][n];
        hp[m - 1][n - 1] = 1 - Math.min(dungeon[m - 1][n - 1], 0);
        for (int j = n - 2; j >= 0; j--) {
            hp[m - 1][j] = Math.max(hp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            hp[i][n - 1] = Math.max(hp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(hp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(hp[i][j + 1] - dungeon[i][j], 1);
                hp[i][j] = Math.min(down, right);
            }
        }
        return hp[0][0];
    }
}

public class Solution {

    public static void main(String[] args) {
        Health x=new Health();
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=sc.nextInt();    
            }
        }
        int health=x.calculateMinimumHP(grid);
        System.out.println(health);  
    }
}
