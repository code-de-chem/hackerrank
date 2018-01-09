package contest.GoDaddy;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class HexagonalWar {
    static int[][] grid;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String result = "";
        int n = in.nextInt();
        int m = in.nextInt();
        if(m < 2*n){
            System.out.println("NEITHER");
        }
        else{
        grid = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = -1;
        int k = 0;
        for(int i = 0; i < m; i++){
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            if(k % 2 == 0){
                if(grid[x][y] == -1)
                    grid[x][y] = 0; //0 for romans
            }
            else{
                if(grid[x][y] == -1)
                    grid[x][y] = 1; //1 for persians
            }
            k++;
        }
        for(int i = n-1; i >= 0; i--){
            if(grid[0][i] == 1){
                persians(n, 0, i);
            }
            if(grid[i][0] == 0)
                romans(n, i, 0);
        }
        System.out.println("NEITHER");
        
        
        
        
        }//end of else
    }
    static void persians(int  n, int i, int j){
            
        if(i == n-1){
            System.out.println("PERSIANS");
            System.exit(0);
        }
        if(i+1 < n)    
            if(grid[i+1][j] == 1)
                persians(n,i+1,j);
        if(j-1 >=0)
            if(grid[i][j-1] == 1)
                persians(n, i, j-1);
        if(i+1 < n && j-1 >=0)
            if(grid[i+1][j-1] == 1)
                persians(n, i+1, j-1);
            
        
    }
    
    static void romans(int  n, int i, int j){
            
        if(j == n-1){
            System.out.println("ROMANS");
            System.exit(0);
        }
        if(j+1 < n)    
            if(grid[i][j+1] == 1)
                persians(n,i,j+1);
        if(i-1 >=0)
            if(grid[i-1][j] == 1)
                persians(n, i-1, j);
        if(j+1 < n && i-1 >=0)
            if(grid[i-1][j+1] == 1)
                persians(n, i-1, j+1);
            
        
    }
}
