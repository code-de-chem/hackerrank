package temp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class Spiral2DMatirx {

    public static void main(String[] args) {
        //int[][] grid = new int[9][9];
        char a = '9';
        System.out.println((int)(a-'0'));
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int  l =0, m = grid[0].length;
        int k = 0, n = grid[0].length;
        while(k<m && l<n){
            for(int i = l; i<n;i++ )System.out.print(grid[k][i]+" ");
            k++;
            for(int i = k; i<m;i++ )System.out.print(grid[i][n-1]+" ");
            n--;
            if(k<m){
            for(int i = n-1; i>=l;i-- )System.out.print(grid[m-1][i]+" ");
            m--;}
            if(l<n){
            for(int i = m-1; i>=k;i-- )System.out.print(grid[i][l]+" ");
            l++;}
        }
    }
    static int distance(int x1, int y1, int x2, int y2){
        double ans = Math.sqrt(Math.abs(Math.pow(x2-x1, 2))+Math.abs(Math.pow(y2-y1, 2)));
        return (int)Math.ceil(ans);
    }
}
