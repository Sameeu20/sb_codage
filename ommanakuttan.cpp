import java.io.*;
import java.util.*;

class calc {
    
        int islandPerimeter(int[][] grid) 
        {
        int row = grid.length;
        int col = grid[0].length;

        int p = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                 if (grid[i][j] == 1) {
                     p += getAdditionalPerimeter(grid, i, j);
                 }  
            }
        }
        return p;
    }
        int getAdditionalPerimeter(int[][] grid, int i, int j) {
        int p = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int row = grid.length;
        int col = grid[0].length;

        for (int[] dir: dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= row || nj < 0 || nj >= col) {
                p++;
                continue;
            }
            if (grid[ni][nj] == 0) {
                p++;
            }
        }
        return p;
    }
        
}

public class Solution {
    

    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        calc c =new calc();
         Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

    int[][] grid = new int[m][n];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
        int perimeter=c.islandPerimeter(grid);
        System.out.println(perimeter);
        
        
    }
}
