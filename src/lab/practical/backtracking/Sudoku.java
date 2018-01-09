package lab.practical.backtracking;

/**
 *
 * @author Saurabh Singh
 */
public class Sudoku {
    static final int EMPTY = 0;
    public static void main(String[] args) {
        // initialize a 9X9 2_d array as sudoku puzzle
        // with empty cell as 0
        int[][] sudoku = {{0, 6, 0, 0, 0, 4, 0, 0, 0},
                          {0, 8, 0, 1, 0, 0, 2, 0, 5},
                          {7, 0, 0, 0, 0, 0, 0, 3, 0},
                          {6, 0, 5, 0, 8, 0, 0, 0, 0},
                          {0, 0, 9, 0, 2, 0, 3, 0, 0},
                          {0, 0, 0, 0, 4, 0, 5, 0, 9},
                          {0, 3, 0, 0, 0, 0, 0, 0, 6},
                          {4, 0, 2, 0, 0, 7, 0, 5, 0},
                          {0, 0, 0, 3, 0, 0, 0, 1, 0}};
        if(solve(sudoku) == true)
            prettyPrint(sudoku);
        else
            System.out.println("No solution possible.");
    }
    
    /** return true if solved */
    static boolean solve(int[][] sudoku){
        int[] cell = new int[2];//cell[0] is row and cell[1] is for column
        if (!isEmpty(sudoku, cell))//no cell is empty
            return true;
 
        //num 1-9 to be filled in cell
        for (int num = 1; num <= 9; num++){
            
            if (isSafe(sudoku, cell, num)){
            
                sudoku[cell[0]][cell[1]] = num;//mark the crrent cell with num
 
                if (solve(sudoku)) // check if solution possible
                    return true;
            
                sudoku[cell[0]][cell[1]] = EMPTY; //demark the cell as it did not lead to the solution
            }
        }
        return false;
    }// end of solve
    
    /* is the current cell empty */
    static boolean isEmpty(int[][] sudoku, int[] cell){
        for (cell[0] = 0; cell[0] < 9; cell[0]++)
            for (cell[1] = 0; cell[1] < 9; cell[1]++)
                if (sudoku[cell[0]][cell[1]] == EMPTY)
                    return true;
        return false;
    }//end of isEmpty
    
    /** return true if num safe to place in current row */
    static boolean isRowSafe(int[][] sudoku, int row, int num){
        for (int col = 0; col < 9; col++)
            if (sudoku[row][col] == num)
                return true;
        return false;
    } // end of isRowSafe
    
    /** return true if num safe to place in current col */
    static boolean isColSafe(int[][] sudoku, int col, int num){
        for (int row = 0; row < 9; row++)
            if (sudoku[row][col] == num)
                return true;
        return false;
    }//end of isColSafe
    
    /** return true if num safe to place in current block */
    static boolean isBlockSafe(int[][] sudoku, int blockRow, int blockCol, int num){
        for (int row = blockRow; row < blockRow + 3; row++)
            for (int col = blockCol; col < blockCol + 3; col++)
                if (sudoku[row][col] == num)
                    return true;
        return false;
    }//end of isBlockSafe
    
    /** return true if num is safe to place in current cell */
    static boolean isSafe(int[][] sudoku, int[] cell, int num){
        return !isRowSafe(sudoku, cell[0], num) && !isColSafe(sudoku, cell[1], num) && !isBlockSafe(sudoku, cell[0] - cell[0]%3 , cell[1] - cell[1]%3, num);
    }//end of isSafe

    /** Prints the Sudoku */
    static void prettyPrint(int[][] sudoku){
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                System.out.print(sudoku[row][col]+" ");
                if(col == 2|| col == 5)
                    System.out.print("| ");
            }
            System.out.println();
            if(row == 2 || row ==5){
                for(int i = 0; i < 11; i++)
                    System.out.print("- ");
                System.out.println();
            }
        }
    }//end of pretttyPrint
    
}// end of class Sudoku