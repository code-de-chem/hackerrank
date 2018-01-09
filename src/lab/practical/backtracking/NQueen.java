package lab.practical.backtracking;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class NQueen {
    static boolean[] colV, upDiag, downDiag;
    static boolean[][] board;
    static long sol = 0;
    public static void main(String[] args) {
        int n;
        try (Scanner in = new Scanner(System.in)) {
            n = in.nextInt();
        }
        colV = new boolean[n];
        upDiag = new boolean[2*n];
        downDiag = new boolean[2*n];
        board = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++)
                board[i][j] = false;
            colV[i] = upDiag[i] = downDiag[i] = true;
        }
        for(int i = n-1; i < 2*n; i++)
            upDiag[i] = downDiag[i] = true;
        if(n > 3)
            chessBoard(0);
        System.out.println(sol);
    }
    
    static void chessBoard(int row){
        if(row == colV.length){
            //printSol();
            //System.exit(0);
            sol++;
        }
        for(int i = 0; i < colV.length; i++){
            if(isSafe(row, i)){
                placeQueen(row, i);
                chessBoard(row+1);
                removeQueen(row, i);
            }
        }
    }
    
    static void placeQueen(int row, int col){
        board[row][col] = true;
        colV[col] = false;
        upDiag[row+col] = false;
        downDiag[colV.length-1+row-col] = false;
    }
    
    static void removeQueen(int row, int col){
        board[row][col] = false;
        colV[col] = true;
        upDiag[row+col] = true;
        downDiag[colV.length-1+row-col] = true;
    }
    
    static boolean isSafe(int row, int col){
        return colV[col] && upDiag[row+col] && downDiag[colV.length-1+row-col];
    }
    
    static void printSol(){
        for(int i = 0; i < colV.length; i++){
            for(int j = 0; j < colV.length; j++)
                if(board[i][j])
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            System.out.println();
        }
            
    }
}
