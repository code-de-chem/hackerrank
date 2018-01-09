package lab.practical;

import java.util.Scanner;

/**
 * @author Saurabh Singh
 */

public class NQueen {
    static int[] position;
    public static void main(String[] args) {
        int n = (new Scanner(System.in)).nextInt();
        position = new int[n];
        if(n < 4)
            System.out.println("No Solution exist. n should be > 4.");
        else
            solve(0, n);
    }
    static void solve(int k, int n){
        if(k == n){
            for(int i = 0; i < n; i++){
                System.out.print(position[i]+" ");
            }
            System.out.println();
        }
        else{
            for(int i=0; i< n; i++){
                if(isSafe(k, i)){
                    position[k] = i;
                    solve(k+1, n);
                }
            }
        }
    }
    
    static boolean isSafe(int queenNo, int rowPos){
        for(int i = 0; i< queenNo; i++){
            int otherRowPos = position[i];
            if(otherRowPos == rowPos || otherRowPos == rowPos -(queenNo-i) || otherRowPos == rowPos + (queenNo - 1)){
                return false;
            }
        }
        return true;
    }
}